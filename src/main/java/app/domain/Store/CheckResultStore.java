package app.domain.Store;

import app.domain.model.AllDates;
import app.domain.model.Client;
import app.domain.model.Test;
import auth.domain.model.Email;

import java.util.Comparator;
import java.util.List;

public class CheckResultStore {

    /**
     * method to get the client
     * @param email client's email
     * @param clientList list of clients registered
     * @return client
     */
    public Client getClient(Email email, List<Client> clientList){
        for (Client client: clientList) {
            if (client.getEmail().equals(email)) {
                return client;
            }
        }
        return null;
    }

    /**
     * method to get the ordered list of dates.
     * @param client client
     * @param datesResult list to add the dates
     * @param testList list of tests
     * @param allDatesList list of all dates
     * @return list of test dates ordered
     */
    public List<AllDates> getListOrdered(Client client, List<AllDates> datesResult, List<Test> testList, List<AllDates> allDatesList){
        for (Test test: testList) {
            if (client.equals(test.getClient())){
                for (AllDates dates: allDatesList){
                    if (dates.getCode().equals(test.getCode())){
                        if (dates.getState().equals("Result"))
                            datesResult.add(dates);
                    }
                }
            }
        }

        datesResult.sort(Comparator.comparing(AllDates::getDate));
        return datesResult;
    }
}
