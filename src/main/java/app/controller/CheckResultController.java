package app.controller;

import app.domain.Store.CheckResultStore;
import app.domain.Store.ClientStore;
import app.domain.Store.DiagnosisStore;
import app.domain.Store.TestStore;
import app.domain.model.*;
import app.domain.shared.ListOfResults;
import auth.domain.model.Email;

import java.util.Comparator;
import java.util.List;

public class CheckResultController implements ListOfResults {
    private Company company;
    private TestStore testStore = new TestStore();
    private ClientStore clientStore = new ClientStore();
    private DiagnosisStore diagnosisStore = new DiagnosisStore();
    private CheckResultStore store = new CheckResultStore();

    public CheckResultController() {
        this.company = App.getInstance().getCompany();
    }

    public CheckResultController(Company company){
        this.company = company;
    }

    /**
     * method to get the client.
      * @param email client's email
     * @return client
     */
    public Client getClient(Email email){
        return this.store.getClient(email, this.clientStore.getClientList());
    }

    public List<AllDates> getListOrdered(Client client, List<AllDates> datesResult){
        return this.store.getListOrdered(client, datesResult, getTestList(), getAllDatesList());
    }

    /**
     * method to get the list of clients.
     * @return clientList
     */
    public List<Test> getTestList() {
        return this.company.getTestList();
    }

    public List<Results> getResultList(){
        return this.company.getResulList();
    }

    public List<AllDates> getAllDatesList(){
        return this.testStore.getDates();
    }

    public List<Diagnosis> getDiagnosisList(){
        return this.diagnosisStore.getDiagnosisList();
    }
}
