package app.domain.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Algoritmo2Test {

    Algoritmo2 algoritmo2 = new Algoritmo2();
    List<Client> clientList = new ArrayList<>();

    @Test
    public void showNameList1() { algoritmo2.showNameList1(clientList); }

    @Test
    public void showTINList() { algoritmo2.showTINList1(clientList); }


}