package app.domain.Store;

import app.domain.model.Algoritmo2;
import app.domain.shared.ListOfClients;
import org.junit.Test;

public class HistoryStoreTest implements ListOfClients {

    HistoryStore historyStore = new HistoryStore();


    @Test
    public void checkAlgorithm1() { historyStore.checkAlgorithm1(); }


    @Test
    public void checkAlgorithm2() { historyStore.checkAlgorithm2(); }

    @Test
    public void getAlgoritmo2() {
        Algoritmo2 algoritmo = historyStore.checkAlgorithm2();
        algoritmo.showTINList1(clientList);
    }
    @Test
    public void getAlgoritmo22() {
        Algoritmo2 algoritmo = historyStore.checkAlgorithm2();
        algoritmo.showNameList1(clientList);
    }

}