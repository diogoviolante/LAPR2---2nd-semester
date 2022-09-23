package app.domain.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class Algoritmo1Test {


    Algoritmo1 algoritmo1 = new Algoritmo1();
    List<Client> clientList = new ArrayList<>();

    @Test
    public void showNameList() { algoritmo1.showNameList(clientList); }

    @Test
    public void showTinList() { algoritmo1.showTinList(clientList); }



}