package app.domain.model;


import app.controller.RegisterResultController;
import app.domain.Store.*;
import app.domain.shared.*;
import auth.AuthFacade;
import auth.domain.model.Email;
import auth.domain.model.Password;
import com.example3.CovidReferenceValues1API;
import com.example1.ExternalModule3API;
import org.apache.commons.lang3.StringUtils;
import java.io.*;
import java.util.Date;
import java.util.List;


/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Company implements ListofTests, ListOfSamples, ListDates, ListOfResults, ListaCategorias, ListOfParameters, ListOfTypes, ListOfEmployees, PastTests,ListOfClients  {

    private Date date;
    private Client client;
    private String designation;
    private AuthFacade authFacade;
    private List<Test> testList;
    private List<Sample> sampleList;
    private List<Test> testWithoutSampleList;
    private TestStore testStore;
    private AvailableTestStore availableTestStore;
    private long testCodeToGenerate;
    private Sample BarcodeGenerator;
    private DiagnosisStore dsStore;

    /**
     * Auxiliar variable
     */
    private int counter = 0;


    public Company(String designation) {
        if (StringUtils.isBlank(designation))
            throw new IllegalArgumentException("Designation cannot be blank.");

        this.designation = designation;
        this.authFacade = new AuthFacade();
        this.testStore = new TestStore();
        this.availableTestStore = new AvailableTestStore();
        this.dsStore = new DiagnosisStore();
    }

    public String getDesignation() {
        return designation;
    }

    public AuthFacade getAuthFacade() {
        return authFacade;
    }

    public TesteType addNewTest(String name, String description, String collectingMethods, String code, List<ParameterCategory> parameterCategoryList) {
        return new TesteType(name, description, collectingMethods, code, parameterCategoryList);
    }

    public boolean validateNewTest(TesteType newTest) {
        if (newTest == null) {
            return false;
        }
        return !this.listTypes.contains(newTest);
    }


    public boolean saveNewTest(TesteType newTest) {
        if (!validateNewTest(newTest))
            return false;
        /*List<String> cat = new ArrayList<>();
        cat.add("bloodcells");
        List<String> cat1 = new ArrayList<>();
        cat1.add("antibodies");
*/
        /*this.newTestContainer.add(new TesteType("CVD1", "covid test", "swab", 12345, cat1));
        this.newTestContainer.add(new TesteType("BL1", "blood test", "blood sample", 54321, cat));


         */
        return this.listTypes.add(newTest);
    }



//-----------------------------Creat a new Employee--------------------------------------------------

    /**
     * @param role the role of the new employee
     * @param employeeID the id
     * @param name the name of the new employee
     * @param address the address
     * @param email the email
     * @param phone_Number the phone number
     * @param soc the soc number
     * @return a new Employee
     */
    public Employee creatEmployee(String role, String employeeID, String name, String address, Email email, String phone_Number, Long soc) {
        return new Employee(role, employeeID, name, address, email, phone_Number, soc);
    }


    /**
     * @param role the role of the new employee
     * @param employeeID the id
     * @param name the name of the new employee
     * @param address the address
     * @param email the email
     * @param phone_Number the phone number
     * @param soc the soc number
     * @param indexNumber the doctor's number
     * @return a new Specialist Doctor
     */
    public Employee creatSpecialistDoctor(String role, String employeeID, String name, String address, Email email, String phone_Number, Long soc, Long indexNumber) throws Exception {
        return new Employee(role, employeeID, name, address, email, phone_Number, soc, indexNumber);
    }


    /**
     * @param employee the employee
     * @return if a employee already exists
     */
    public boolean validateEmployee(Employee employee) {
        if (employee == null) {
            return false;
        } else {
            for (Employee employee1 : employeesList) {
                if (employee.getName().equalsIgnoreCase(employee1.getName())) {
                    return false;
                }
            }
            return !this.employeesList.contains(employee);
        }
    }


    /**
     *  generate login data to the employee
     *
     * @param email email of the new employee
     * @param name name of the new employee
     * @throws IOException exception ro generate password.
     */
    public void generatePass (Email email, String name, String role) throws IOException {

        String pass = Password.generatePW(10);
        getAuthFacade().addUserWithRole(name, String.valueOf(email), pass, role);

        File file = new File("Employees\\emailAndSMSMessages.txt");
        PrintWriter print = new PrintWriter(new FileWriter(file));

        print.append("Employee: ").append(name);
        print.append("\nEmail: ").append(String.valueOf(email));
        print.append("\n Password: ").append(pass);
        print.close();
    }




    /**
     * @param employee to save the employee
     */
    public void saveEmployee(Employee employee) {
        if (validateEmployee(employee)) {
            this.employeesList.add(employee);
            try {
                this.generatePass(employee.getEmail(), employee.getName(), employee.getRole());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

//------------------------------------------------------------------------------------



    /**
     * @param newTest to save the test
     */



    /**
     * returns the store
     */
    public ClinicalAnalysisLabStore getStore() {
        return new ClinicalAnalysisLabStore(this);
    }


    public ParameterCategory createParameterCategory(String code, String name) {
        return new ParameterCategory(code, name);
    }

    /**
     * @param pc the parameter category
     * @return false if it's null
     */
    public boolean validateParameterCategory(ParameterCategory pc) {
        if (pc == null) {
            return false;
        } else {
            for (ParameterCategory parameterCategory : listacategorias) {
                if (parameterCategory.getCode().equalsIgnoreCase(pc.getCode())) {
                    return false;
                }
            }
            return !this.listacategorias.contains(pc);
        }
    }

    /**
     * @param pc the parameter category
     * @return false if isn't validated or true if it's added
     */
    public boolean saveParameterCategory(ParameterCategory pc) {
        if (!validateParameterCategory(pc))
            return false;
        return this.listacategorias.add(pc);
    }

    public ParameterCategory getParameterCategoryByName(String name) {
        ParameterCategory parameterCategory = null;
        for (ParameterCategory parameterCategory1 : listacategorias) {
            if (name.equals(parameterCategory1.getName())) {
                parameterCategory = parameterCategory1;

                return parameterCategory;
            }

        }
        return parameterCategory;
    }
/*public Parameter getParameterByCode(int paramterCode){
        for(Parameter parameter : parameterList) {
            if((parameter.getParameterCode())==paramterCode){
                return parameter;
            }
    }
return null;
    }*/



//------------------------------Collects a Sample------------------------------------------------

    /**
     * Returns specific test
     *
     * @param code code of the test
     * @return test
     */
    public Test getTestByCode(String code) {
        for (Test t : listOfTests) {
            if (t.getCode().equals(code)) {
                return t;
            }
        }
        return null;
    }



    /**
     * @return sample list
     */
    public List<Sample> getSampleList() {
        return sampleList;
    }



    /**
     * Registers new sample associated with the test
     *
     * @return new sample
     */
    public Sample registSample(String code) throws Exception {
        Sample sample1 = new Sample(code);
        sample1.generateEAN13BarcodeImage(sample1.getCode());
        counter++;
        return sample1;
    }



    /**
     * @param sample the sample
     * @return false if it's null
     */
    public boolean validateSample(Sample sample) {
        if (sample == null) {
            return false;
        } else {
            String code = sample.getCode();
            datesList.add(new AllDates(code, new Date(), "Sample"));
            return true;
        }
    }



    /**
     * @param sample the sample
     * @return false if isn't validated or true if it's added
     */
    public boolean saveSample(Sample sample) {
        if (!validateSample(sample)) {
            return false;
        }
        return addSample(sample);
    }



    /**
     * @param sample the sample
     * @return add sample
     */
    public boolean addSample(Sample sample) {
        return samplesList.add(sample);
    }

//----------------------------------------------------------------------------------------------




//---------------------------Register test Result----------------------------------------------------



    /**
     * choses the test type from a list
     */
    public TesteType getTestType(String barCodeString) {
        for (Test t : listOfTests) {
            for (Sample s : samplesList) {
                if (s.getCode().equals(barCodeString)) {
                    return t.getType();
                }
            }
        }
        return null;
    }



    public Test getTestWithBarcode(String barCodeString) {
        for (Test t : listOfTests) {
            for (Sample s : samplesList) {
                if (s.getCode().equals(barCodeString)) {
                    return t;
                }
            }
        }
        return null;
    }

    public Test getTestFromBarcode(String barcodeString){
        for (Test list: pastTests){
            if (list.getCode().equals(barcodeString)){
                return list;
            }
        }
        return null;
    }



    public void addToList(Test t) {
        datesList.add(new AllDates(t.getCode(), new Date(), "Result"));
    }

    /**
     *
     * @param barcodeString the barcode
     * @return if its validated
     */
    public boolean validateBarcodeString(String barcodeString) {
        if (barcodeString.length() == 12) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @param parameter parameter value
     * @param accessKey access only to authorized employees
     * @param parameterID covid values
     * @return result
     */
    public String covidAPI1(double parameter, int accessKey, String parameterID) {
        CovidReferenceValues1API covid = new CovidReferenceValues1API();
        System.out.println("Your value:" + parameter);
        System.out.println("Metrics:" + covid.usedMetric(parameterID, accessKey));
        String metrics = covid.usedMetric(parameterID, accessKey);
        String resultboolean;
        if (parameter >= covid.getMaxReferenceValue(parameterID, accessKey)) {
            System.out.println("Tested positive for Covid-19.");
            resultboolean = "Positive";
        } else {
            System.out.println("Tested negative for Covid-19.");
            resultboolean = "Negative";
        }

        return resultboolean;
    }

    public String covidAPI11(double parameter, int accessKey, String parameterID) {
        CovidReferenceValues1API covid = new CovidReferenceValues1API();

        String metrics = covid.usedMetric(parameterID, accessKey);
        String resultboolean;
        if (parameter >= covid.getMaxReferenceValue(parameterID, accessKey)) {
            resultboolean = "Positive";
        } else {
            resultboolean = "Negative";
        }

        return resultboolean;
    }


    /**
     *
     * @param parameter parameter value
     * @param parameters parameter evaluated
     * @param accessKey access only to authorized employees
     * @return result
     */
    public String bloodAPI3(double parameter, String parameters, int accessKey) {
        ExternalModule3API externalModule3API = new ExternalModule3API();
        String metrics = externalModule3API.usedMetric(parameters, accessKey);
        System.out.println("Your value:" + parameter);
        System.out.println("Metrics:" + metrics);
        String resultBoolean;
        if (parameter >= externalModule3API.getMinReferenceValue(parameters, accessKey)
                && parameter <= externalModule3API.getMaxReferenceValue(parameters, accessKey)) {
            System.out.println("The values are normal\n");
            resultBoolean = "The values are normal";
        } else if (parameter < externalModule3API.getMinReferenceValue(parameters, accessKey)) {
            System.out.println("The value is less than normal\n");
            resultBoolean = "The value is less than normal";
        } else if (parameter > externalModule3API.getMaxReferenceValue(parameters, accessKey)) {
            System.out.println("The value is higher than normal\n");
            resultBoolean = "The value is higher than normal";
        } else {
            System.out.println("The number is not normal\n");
            resultBoolean = "The number is not normal";
        }
        return resultBoolean;
    }

    public String bloodAPI31(double parameter, String parameters, int accessKey) {
        ExternalModule3API externalModule3API = new ExternalModule3API();
        String metrics = externalModule3API.usedMetric(parameters, accessKey);
        String resultBoolean;
        if (parameter >= externalModule3API.getMinReferenceValue(parameters, accessKey)
                && parameter <= externalModule3API.getMaxReferenceValue(parameters, accessKey)) {
            resultBoolean = "The values are normal";
        } else if (parameter < externalModule3API.getMinReferenceValue(parameters, accessKey)) {
            resultBoolean = "The value is less than normal";
        } else if (parameter > externalModule3API.getMaxReferenceValue(parameters, accessKey)) {
            resultBoolean = "The value is higher than normal";
        } else {
            resultBoolean = "The number is not normal";
        }
        return resultBoolean;
    }




//-------------------------------------------------------------------------------------------------------






//public TesteType choseTest(){
    //     Scanner ler=new Scanner(System.in);
    //    int code2 =ler.nextInt();
    //  this.newTestContainer=newTestContainer;
    //for(TesteType clientTest:newTestContainer){
    // if (code2==clientTest.getCode()){
    //return clientTest;
    //}
    //}

    //return null;
//}


//------------------------------Register Test---------------------------------------------
    /**
     * return client
     */
    public Client getClient(Long taxNumber) {
        return ClientStore.getClient(taxNumber);
    }

    /**
     * return test type container
     */
    public List<TesteType> getNewTestContainer() {
        return listTypes;
    }
    /**
     * return ParameterCategoryList
     */
    public List<ParameterCategory> getParameterCategoryList() {
        return listacategorias;
    }
    /**
     * return ParameterList
     */
    public List<Parameter> getParametersList() {
        return parameterList;
    }
    /**
     * return test store
     */
    public TestStore getTestStore() {
        return testStore;
    }
    /**
     * return test list
     */
    public List<Test> getTestList() {
        return this.testStore.getTestList();
    }

    public List<Client> getClientList(){
        return clientList;
    }

    public List<Diagnosis> getDSList(){return dsStore.getDiagnosisList();}

    public List<Results> getResulList(){return resultsList;}

    //----------------------------------------------------------------------------------------
    /**
     * return validation coordinator list
     */
    public List <ValidationCoordinator> getValidationCoordinatorList() throws Exception {
        return getValidationCoordinatorList();
    }

    public AvailableTestStore getAvailableTestStore() {
        return availableTestStore;
    }
}