package app.domain.model;

import app.domain.Store.AvailableTestStore;
import app.domain.Store.TestStore;
import app.domain.shared.Constants;
import app.domain.shared.ListOfClients;
import app.domain.shared.ListofTests;
import auth.AuthFacade;
import auth.domain.model.Email;
import auth.domain.model.Password;
import org.junit.Test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.*;


public class CompanyTest implements ListofTests, ListOfClients {




//-------------------------------------------------------------------------------------------------
    TestStore testStore = new TestStore();
    List<ParameterCategory> parameterCategoryList = new ArrayList<>();
    TesteType testeType = new TesteType("yauu", "yauuuuuu", "yaaaauuuuuuuuu", "12345", parameterCategoryList);
    Company company2 = new Company(Constants.PARAMS_COMPANY_DESIGNATION);

    String name2 = "yauu";
    String description = "yauuuuuu";
    String collectingMethods = "yaaaauuuuuuuuu";
    String code = "12345";


    @Test
    public void getDesignation() {
        String expresult = company2.getDesignation();
        String result = company.getDesignation();
        assertEquals(expresult, result);
    }

    @Test
    public void getAuthFacade() {
        AuthFacade expresult = company.getAuthFacade();
        AuthFacade result = company.getAuthFacade();
        assertEquals(expresult, result);
    }

    @Test
    public void addNewTest() { company.addNewTest(name2, description, collectingMethods, code, parameterCategoryList); }

    @Test
    public void validateNewTest() { company.validateNewTest(null); }
    @Test
    public void validateNewTest2() { company.validateNewTest(testeType); }


    //------------------------------------------------------------------------------------------------






    //-----------------------------------------Register Employee---------------------------------------------------
    Company company = new Company(Constants.PARAMS_COMPANY_DESIGNATION);
    Employee expresult = new Employee("Receptionist", "PS00001", "Pedro Sousa", "100 rua Egas Moniz", new Email("123@isep.pt") , "12345678911", 1234L);

    String role = "Receptionist";
    String employeeID = "PS00001";
    String name = "Pedro Sousa";
    String address = "100 rua Egas Moniz";
    Email email = new Email("123@isep.pt");
    String phoneNumber = "12345678911";
    Long soc = 1234L;
    Long indexNumber = 123456L;
    private Employee employeesList;

    public CompanyTest() throws Exception {}

    @Test
    public void validateEmployee() { company.validateEmployee(expresult); }
    @Test
    public void validateEmployee2() { company.validateEmployee(null); }
    @Test
    public void validateEmployee3() {
        Employee result = company.creatEmployee("Receptionist", "PS00001", "Pedro Sousa", "100 rua Egas Moniz", new Email("123@isep.pt") , "12345678911", 1234L);
        Boolean certo = result.getName().equalsIgnoreCase(expresult.getName());
    }


    @Test
    public void saveEmployee() { company.saveEmployee(expresult); }
    @Test
    public void saveEmployee1() { company.saveEmployee(null); }


    @Test
    public void creatEmployee() { company.creatEmployee(this.role, this.employeeID, this.name, this.address, this.email, this.phoneNumber, this.soc); }


    @Test
    public void creatSpecialistDoctor() throws Exception { company.creatSpecialistDoctor(this.role, this.employeeID, this.name, this.address, this.email, this.phoneNumber, this.soc, this.indexNumber); }



    @Test
    public void generatePass() throws IOException {
        String pass = Password.generatePW(10);

        File file = new File("Employees\\emailAndSMSMessages.txt");
        PrintWriter print = new PrintWriter(new FileWriter(file));

        print.append("Employee: ").append(name);
        print.append("\nEmail: ").append(String.valueOf(email));
        print.append("\n Password: ").append(pass);
        print.close();
    }

    //----------------------------------------------------------------------------------





    //----------------------------------------Register Sample-----------------------------------------------------

    Sample sample = new Sample("000000000001");

    @Test
    public void getTestByCode() { company.getTestByCode("000000000001"); }
    @Test
    public void getTestByCode2() { company.getTestByCode(null); }


    @Test
    public void validateSample() { company.validateSample(sample); }


    @Test
    public void getSampleList() { List<Sample> result = company.getSampleList(); }


    @Test
    public void registSample() throws Exception { company.registSample("000000000001"); }


    @Test
    public void testValidateSample() { company.validateSample(sample); }
    @Test
    public void testValidateSample2() { company.validateSample(null); }


    @Test
    public void saveSample() { company.saveSample(sample); }
    @Test
    public void saveSample2() { company.saveSample(null); }


    @Test
    public void addSample() { company.addSample(sample); }
    @Test
    public void addSample2() { company.addSample(null); }

    //----------------------------------------------------------------------------------------






    //--------------------------------------Register Test---------------------------------------------

    Client client = new Client("Rodrigo","1234567891234567",12345678911L,1234567891L,1234567891L,new Date("27/05/2002"),"Client", new Email("client@isep.pt"),"yauuuu");


    @Test
    public void getClient() { company.getClient(1234567891L); }

    @Test
    public void getNewTestContainer() { List<TesteType> result = company.getNewTestContainer(); }

    @Test
    public void getParameterCategoryList() { List<ParameterCategory> result = company.getParameterCategoryList(); }

    @Test
    public void getParametersList() { List<Parameter> result = company.getParametersList(); }

    @Test
    public void getTestStore() { TestStore result = company.getTestStore(); }

    @Test
    public void getTestList() { List<app.domain.model.Test> result = company.getTestList(); }

    //--------------------------------------------------------------------------------------------






    //------------------------------------------------------------------------------------------------
    String barcode = "000000000001";
    List<Parameter> parameters = new ArrayList<>();
    app.domain.model.Test test = new app.domain.model.Test(client, barcode, "123456789123", testeType, parameters, "12345L", new Date("27/05/2002") );

    double parameter = 12345;
    int accessKey = 12345;
    String parameterId = "12345";



    @Test
    public void getTestType() { company.getTestType(barcode); }

    @Test
    public void getTestWithBarcode() { company.getTestWithBarcode(barcode); }

    @Test
    public void getTestFromBarcode() { company.getTestFromBarcode(barcode); }

    @Test
    public void addToList() { company.addToList(test); }

    @Test
    public void validateBarcodeString() { company.validateBarcodeString(barcode); }

    @Test
    public void covidAPI1() { company.covidAPI1(parameter, accessKey, parameterId); }

    @Test
    public void bloodAPI3() { company.bloodAPI3(parameter, parameterId, accessKey); }

    @Test
    public void covidAPI11() { company.covidAPI11(parameter, accessKey, parameterId); }

    @Test
    public void bloodAPI31() { company.bloodAPI31(parameter, phoneNumber,  accessKey); }

    //-----------------------------------------------------------------------------------------








    //-----------------------------------------------------------------------------------------

    ParameterCategory parameterCategory = new ParameterCategory("12345", "covid");

    @Test
    public void saveNewTest() { company.saveNewTest(testeType); }

    @Test
    public void getStore() { company.getStore(); }

    @Test
    public void createParameterCategory() { company.createParameterCategory("12345", "covid"); }

    @Test
    public void validateParameterCategory() { company.validateParameterCategory(parameterCategory); }

    @Test
    public void saveParameterCategory() { company.saveParameterCategory(parameterCategory); }

    @Test
    public void getParameterCategoryByName() { company.getParameterCategoryByName("covid"); }

    @Test
    public void getAvailableTestStore() { AvailableTestStore result = company.getAvailableTestStore(); }

    //------------------------------------------------------------------------------------------




}