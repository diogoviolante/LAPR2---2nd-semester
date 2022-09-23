package app.domain.Store;

import app.domain.model.*;
import app.domain.shared.ListDates;
import app.domain.shared.ListofTests;

import java.util.Date;
import java.util.List;

public class TestStore implements ListofTests, ListDates {

    /**
     * code to be generated to identify the tests.
     */
    private Long code = 0L;

    /**
     * attribute from Date class.
     */
    private Date date = new Date();
    /**
     * Date to be saved in the ArrayList dates.
     */
    private Long longDate;

    /**
     * Method to register a new test.
     * @param client information of the client who is going to be tested.
     * @param code code generated to identify the test.
     * @param nhsCode NHS code used to identify the test.
     * @param type type of test to be analysed.
     * @param parameters parameters to be tested.
     * @return a registered test.
     */
    public Test createTest(Client client, String code, String nhsCode, TesteType type, List<Parameter> parameters, String  labId, Date date) {
        return new Test(client, code, nhsCode, type, parameters, labId, date);
    }

    /**
     * Method to validate a newly registered test.
     * @param newTest newly registered test.
     * @return if test is valid or not.
     */
    public boolean validateTest(Test newTest) {
        try{
            if (newTest == null) {
                return false;
            } else {
                for (Test testCheck : listOfTests) {
                    if (newTest.getNhsCode().equals(testCheck.getNhsCode())) {
                        return false;
                    }
                }
            }
        }catch (IllegalArgumentException i){
            i.getMessage();
        }
        return !listOfTests.contains(newTest);
    }

    /**
     * Method to add the test to the ArrayList testList and to add the registration dates to the ArrayList dates.
     * @param newTest newly registered tests.
     */
    public void saveTest(Test newTest) {
        if (validateTest(newTest)) {
            this.listOfTests.add(newTest);
            this.datesList.add( new AllDates(newTest.getCode(), newTest.getDate(), "Register"));

            /*try {
                this.generateFile(newTest);
            } catch (IOException e) {
                e.printStackTrace();
            }

             */
        }
    }

    /**
     * Method to generate the code which will identify the registered test.
     * @return code of the test.
     */
    public String generateCode() {
        this.code = this.code +1;

        return String.format("%012d",this.code);
    }

    /**
     * method to get the list of dates.
     * @return dates List
     */
    public List<AllDates> getDates(){return datesList;}

    /**
     * method to set the date for the Laboratory Coordinator.
     * @param date date when action occured
     */
    public void setDateLaboratoryCoordinator(Date date) {
        this.date = date;
    }

    /**
     * method to get the list of tests.
     * @return list of registered testes
     */
    public List<Test> getTestList() { return listOfTests;}

}
