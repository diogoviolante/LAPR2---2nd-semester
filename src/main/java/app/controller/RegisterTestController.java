package app.controller;

import app.domain.Store.ClientStore;
import app.domain.Store.TestStore;
import app.domain.model.*;

import java.util.Date;
import java.util.List;

public class RegisterTestController {
        /**
         * variable from calls Client.
         */
        private Client client;

        /**
         * variable from class Company.
         */
        private Company company;

        /**
         * variable from class ClientStore.
         */
        private ClientStore store = new ClientStore();

        /**
         *variable from class TestStore.
         */
        private TestStore storeTest = new TestStore();

        /**
         * variable from class Test
         */
        private Test test;

        /**
         * List from class Client.
         */
        private List<Client> clientList = store.getClientList();

        /**
         * RegisterTestController constructor.
         */
        public RegisterTestController() { this.company = App.getInstance().getCompany(); }

        /**
         * RegisterTestController constructor.
         * @param company attribute from class Company
         */
        public RegisterTestController(Company company) {
                this.company = company;
                this.client = null;
        }

        /**
         * nethod that gets the List of types of test.
         * @return newTestContainer
         */
        public List<TesteType> getTypeList() { return this.company.getNewTestContainer(); }

        /**
         * method to get the List of categories.
         * @return paramaterCategoryList
         */
        public List<ParameterCategory> getCategoryList() {return this.company.getParameterCategoryList(); }

        /**
         * method to get List of parameters.
         * @return parameterList
         */
        public List<Parameter> getParametersList() {return this.company.getParametersList(); }

        /**
         * method to generate the new code of the registered test.
         * @return code
         */
        public String generateCode() {
                return this.storeTest.generateCode();
        }

        /**
         * method that creates the test to be registered.
         * @param client client info
         * @param code test code
         * @param nhsCode test NHS code
         * @param type test type
         * @param parameters parameters to be analysed
         * @return test to be registered
         */
        public Test registerTest(Client client, String code, String nhsCode, TesteType type, List<Parameter> parameters, String labId, Date date) {
                return this.test = this.storeTest.createTest(client, code, nhsCode, type, parameters,labId, date);
        }

        /**
         * method to register the test.
         * @param test test
         */
        public void saveTest(Test test) {
                this.storeTest.saveTest(test);
        }

        public List<Test> getTestList(){
                return this.storeTest.getTestList();
        }
}
