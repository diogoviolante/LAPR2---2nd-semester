package app.domain.model;

import app.controller.App;
import app.controller.NewTestController;
import app.controller.RegisterResultController;
import app.domain.Store.*;
import app.domain.shared.ListOfClients;
import app.domain.shared.ListOfParameters;
import app.domain.shared.ListaCategorias;
import auth.domain.model.Email;

import java.io.*;
import java.lang.reflect.Array;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.Double.parseDouble;

public class CVSfiles implements ListaCategorias,  ListOfClients {
   private Sample sample;
    private Company company= App.getInstance().getCompany();
    private TesteType testeType;
    FileReader first;
    private ClientStore clientStore=new ClientStore();
   private ClinicalAnalysisLabStore labStore;
   private Test test;
   private TestStore testStore= new TestStore();
   private ParameterStore parameterStore=new ParameterStore();
   Scanner ler= new Scanner(System.in);
   private RegisterResultController resultController=new RegisterResultController();
   private  TesteType newType = null;

  private List<String> info ;
private DiagnosisStore dstore=new DiagnosisStore();
    private NewTestController newTestController= new NewTestController();
    NumberFormat numberFormat = NumberFormat.getInstance(Locale.FRANCE);
    public CVSfiles() {
this.info=new ArrayList<>();
    }

    public  BufferedReader LoadDataFileMATCPMDISC() throws FileNotFoundException {

        BufferedReader reader = new BufferedReader(new FileReader("ficheiros de import\\tests_BloodCovidMATCPMDISCCSV.csv"));
   return reader;
    }
public  BufferedReader LoadDataFileMATCP() throws FileNotFoundException{
        BufferedReader reader=new BufferedReader(new FileReader("ficheiros de import\\tests_CovidMATCPCSV.csv"));
return reader;
    }
    public  BufferedReader LoadDataFileMDISC()throws FileNotFoundException{
        BufferedReader reader= new BufferedReader(new FileReader("ficheiros de import\\tests_BloodMDISCCSV.csv"));
    return reader;
    }

    public BufferedReader ChoseOption(int option) throws FileNotFoundException {

        BufferedReader reader = null;
        if(option==1){
             reader=LoadDataFileMATCPMDISC();
        }else if(option==2){
             reader=LoadDataFileMATCP();
        }else if(option==3){
             reader=LoadDataFileMDISC();
        }

        return reader;
    }

    public void CreateNewClient(int option) throws IOException {

Client newClient=null;
        try{
            BufferedReader reader=ChoseOption(option);

        String line1=null;
            while ((line1 = reader.readLine()) != null) {
                String data = reader.readLine();



                info = Arrays.asList(data.split(";"));
           String name= info.get(8);
           String citizenNumberString=info.get(3);

                long nhsNumber = Long.parseLong(info.get(4));
           long taxNumber= Long.parseLong(info.get(5));
           String birthDateString=info.get(6);
          Date birthDate= new Date(birthDateString);
           long phoneNumber= Long.parseLong(info.get(7));

           String adress= info.get(10);

              try {
                  String emailString = info.get(9);
                  Email email = new Email(emailString);
                  newClient = clientStore.createClient(name, citizenNumberString, phoneNumber, nhsNumber, taxNumber, birthDate, email, adress);
                  clientStore.saveClient2(newClient);
              }catch (IllegalArgumentException e){
                  //System.out.println(e.getMessage());
              }

            }


        }catch (FileNotFoundException | IllegalArgumentException | NullPointerException e){
            e.getMessage();
        }

    }

   public Test AddTest(int option){
       // int option1=option;
        Test test=null;
        try{
            BufferedReader reader=ChoseOption(option);
            String line1=null;

            CreateNewClient(option);

            while ((reader.readLine()) != null) {
                String data = reader.readLine();
                String[] info = new String[5000];
                if (data != null) {
                    info = data.split(";");
                    String citizenNumberStringtest = info[3];
                    Client clientForTest = null;
                    try {

                        for (Client newClient : clientList) {
                            if (newClient.getCitizenNumber().equals((citizenNumberStringtest))) {
                                clientForTest = newClient;
                            }
                        }

                        String code = info[0];
                        String nhsCode = info[1];
                        String type = info[11];
                        String labId = info[2];
                        List<Parameter> parameters = parameterStore.getParamterList();
                        List<ParameterCategory> categories = company.getParameterCategoryList();
                        String testDate = info[info.length - 4];
                        String[] t = testDate.split(" ");
                        String[] hora = t[1].split(":");
                        String[] t2 = t[0].split("/");
                        Calendar cal = Calendar.getInstance();
                        cal.set(Integer.parseInt(t2[2]), Integer.parseInt(t2[1])-1, Integer.parseInt(t2[0]), Integer.parseInt(hora[0]), Integer.parseInt(hora[1]));

                        for (TesteType type2 : this.company.getNewTestContainer()) {
                            if (type.equals(type2.getName())) {
                                this.newType = type2;
                            }
                        }
                        test = testStore.createTest(clientForTest, code, nhsCode, this.newType, parameters, labId, cal.getTime());
                        testStore.saveTest(test);

                        sample=company.registSample(code);
                        List<AllDates> allDatesList=dstore.getDateList();
                        allDatesList.add(new AllDates(code,cal.getTime(),"Sample"));
                        String diagnosisDate = info[info.length - 2];
                        String[] t1 = diagnosisDate.split(" ");
                        String[] hora2 = t1[1].split(":");
                        String[] t3 = t1[0].split("/");
                        Calendar cal1 = Calendar.getInstance();
                        cal1.set(Integer.parseInt(t3[2]), Integer.parseInt(t3[1])-1, Integer.parseInt(t3[0]), Integer.parseInt(hora2[0]), Integer.parseInt(hora2[1]));
                        Diagnosis diagnosis= new Diagnosis(" Diagnosis",cal1.getTime(),code);
                        allDatesList.add(new AllDates(code,cal1.getTime(),"Diagnosis"));
                    } catch (IllegalArgumentException e) {
                        e.getMessage();
                    } catch (Exception e) {
                        e.getMessage();
                    }
                }
            }

            AssociateCategoriesandParameters(option);
            System.out.println("Number of registered clients: ");
            System.out.println(clientList.size());

            System.out.println("Number of tests registered in the system: ");
            System.out.println(testStore.getTestList().size());

            System.out.println("Number of tests with result: ");
            int count =0 ;
            for (AllDates x : dstore.getDateList()){
                if (x.getState().equals("Result")){
                    count++;
                }
            }
            System.out.println(count);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
   return test;
    }



    public void AssociateCategoriesandParameters(int option) throws IOException {
        BufferedReader reader= null;
        try {
            reader = ChoseOption(option);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



        try {
            String data = reader.readLine();
            String[] info = new String[5000];
            if (data != null){
                info = data.split(";");

            while ((reader.readLine()) != null) {
                for (int i = 11; i < info.length - 4; i++) {
                    if (info[i].equals("Category")) {
                        String cat = "Category";

                        for (ParameterCategory pc : listacategorias) {

                            String afterfirstline = reader.readLine();
                            String[] info2 = new String[5000];
                            if (afterfirstline == null) {

                            } else if (afterfirstline != null) {
                                info2 = afterfirstline.split(";");
                                if (info2[i].equals("NA")) {

                                } else if (pc.getName().equals(info2[i])) {
                                    if (info2[i].equals("Covid")) {
                                        String parameter = "IgGAN";

                                        String parameterValue =  ((info2[i + 1]));
                                        parameterValue=parameterValue.replace(",",".");
                                        String result = resultController.covidAPI11(Double.parseDouble(parameterValue), 12345, parameter);
                                        String testType=info2[11];
                                        String testCode=info2[0];
                                        resultController.createResult(testType, parameter, testCode, result, Double.parseDouble(parameterValue));
                                        String dateresultString = info2[info2.length - 3];
                                        String[] t = dateresultString.split(" ");
                                        String[] hora = t[1].split(":");
                                        String[] t2 = t[0].split("/");
                                        Calendar cal = Calendar.getInstance();
                                        cal.set(Integer.parseInt(t2[2]), Integer.parseInt(t2[1])-1, Integer.parseInt(t2[0]), Integer.parseInt(hora[0]), Integer.parseInt(hora[1]));

                                        List<AllDates> allDatesList = dstore.getDateList();
                                        List<AllDates> checker = List.copyOf(allDatesList);
                                        allDatesList.add(new AllDates(testCode, cal.getTime(), "Result"));
                                    } else if (info2[i].equals("Hemogram")) {
                                        String parameter1 = "HB000";
                                        String testType=info[11];
                                        String parameterValue1 = (info2[i + 1]);
                                        parameterValue1=parameterValue1.replace(",",".");
                                        String result1 = resultController.bloodAPI31(Double.parseDouble(parameterValue1), parameter1, 12345);
                                        String code=info[0];
                                        resultController.createResult(testType, parameter1, code, result1, Double.parseDouble(parameterValue1));
                                        String parameter2 = "WBC00";
                                       String parameterValue2 = info2[i + 2];
                                       parameterValue2=parameterValue2.replace(",",".");
                                       String result2 = resultController.bloodAPI31(Double.parseDouble(parameterValue2), parameter2, 12345);
                                        resultController.createResult(testType, parameter2, code, result2, Double.parseDouble(parameterValue2));
                                        String parameter3 = "PLT00";
                                        String parameterValue3 = (info2[i + 3]);
                                        parameterValue3=parameterValue3.replace(",",".");
                                        String result3 = resultController.bloodAPI31(Double.parseDouble(parameterValue3), parameter3, 12345);
                                        resultController.createResult(testType, parameter3, code, result3, Double.parseDouble(parameterValue3));
                                        String paremeter4 = "RBC00";
                                        String paremeterValue4 = (info2[i + 4]);
                                        paremeterValue4= paremeterValue4.replace(",",".");
                                        String result4 = resultController.bloodAPI31(Double.parseDouble(paremeterValue4), paremeter4, 12345);
                                        resultController.createResult(testType, paremeter4, code, result4, Double.parseDouble(paremeterValue4));
                                        String dateresultString = info2[info2.length - 2];
                                        String[] t = dateresultString.split(" ");
                                        String[] hora = t[1].split(":");
                                        String[] t2 = t[0].split("/");
                                        Calendar cal = Calendar.getInstance();
                                        cal.set(Integer.parseInt(t2[2]), Integer.parseInt(t2[1])-1, Integer.parseInt(t2[0]), Integer.parseInt(hora[0]), Integer.parseInt(hora[1]));

                                        List<AllDates> allDatesList = dstore.getDateList();
                                        allDatesList.add(new AllDates(code, cal.getTime(), "Result"));
                                    } else if (info2[i].equals("Cholesterol")) {
                                        String testType=info[11];
                                        String parameter1 = "HDL00";
                                        String paremterValue1 = String.valueOf(parseDouble(info2[i + 1]));
                                        paremterValue1=paremterValue1.replace(",",".");
                                        String code=info[0];
                                        String result = resultController.bloodAPI31(Double.parseDouble(paremterValue1), parameter1, 12345);
                                        resultController.createResult(testType, parameter1, code, result, Double.parseDouble(paremterValue1));
                                        String dateresultString = info2[info2.length - 2];
                                        String[] t = dateresultString.split(" ");
                                        String[] hora = t[1].split(":");
                                        String[] t2 = t[0].split("/");
                                        Calendar cal = Calendar.getInstance();
                                        cal.set(Integer.parseInt(t2[2]), Integer.parseInt(t2[1])-1, Integer.parseInt(t2[0]), Integer.parseInt(hora[0]), Integer.parseInt(hora[1]));
                                        List<AllDates> allDatesList = dstore.getDateList();
                                        allDatesList.add(new AllDates(code, cal.getTime(), "Result"));
                                    }

                                }
                            }
                        }
                    }

               }
            }
        }
        } catch (NumberFormatException e){
            System.out.println("value isnt valid");
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }


    }
}



