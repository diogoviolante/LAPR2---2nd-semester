package app.domain.Store;

import app.domain.model.AllDates;
import app.domain.model.Client;
import auth.domain.model.Email;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class CheckResultStoreTest {

    CheckResultStore checkResultStore = new CheckResultStore();
    Client client = new Client("violas", "1234567891234567", 12345678971L, 1234567891L, 1234567891L, new Date("2002/3/30"), "MALE", new Email("dsviolante@gmail.com"), "yauuuu");
    Client client2 = new Client("violas", "1234567891234567", 12345678971L, 1234567891L, 1234567891L, new Date("2002/3/30"), "MALE", new Email("violante@gmail.com"), "yauuuu");
    List<Client> clientList = new ArrayList<>();
    List<AllDates> datesResult = new ArrayList<>();
    List<app.domain.model.Test> testList = new ArrayList<>();
    List<AllDates> allDatesList = new ArrayList<>();


    @Test
    public void getClient() { checkResultStore.getClient(new Email("dsviolante@gmail.com"), clientList); }
    @Test
    public void getClient2() { checkResultStore.getClient(new Email("e@gmail.com"), clientList); }
    @Test
    public void getClient3() { checkResultStore.getClient(new Email("violante@gmail.com"), clientList); }




    @Test
    public void getListOrdered() { checkResultStore.getListOrdered(client, datesResult, testList, allDatesList); }
    @Test
    public void getListOrdered2() { checkResultStore.getListOrdered(client2, datesResult, testList, allDatesList); }





}