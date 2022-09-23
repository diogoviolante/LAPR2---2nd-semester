package app.controller;

import app.domain.Store.AvailableTestStore;
import app.domain.Store.HistoryStore;
import app.domain.model.*;

import java.io.IOException;
import java.util.List;

public class ConsultHistoryController {
    private HistoryStore store= new HistoryStore();
    private Algoritmo1 algoritmo1=new Algoritmo1();
    private Algoritmo2 algoritmo2=new Algoritmo2();

    public void getAlgoritmo1() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        store.getAlgoritmo1();
    }

    public void getAlgoritmo2() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        store.getAlgoritmo2();
    }

    public void chooseTest(){
        store.chooseTest();
    }

    public Algoritmo1 checkAlgorithm1(){
        return store.checkAlgorithm1();
    }

    public Algoritmo2 checkAlgorithm2(){
        return store.checkAlgorithm2();
    }
}
