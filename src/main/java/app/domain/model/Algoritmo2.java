package app.domain.model;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Comparator;
import java.util.List;

public class Algoritmo2 {
    private Test test;

    public void showNameList1(List<Client> clientList){
        StopWatch oleole=new StopWatch();
        oleole.start();
        clientList.sort(Comparator.comparing(Client::getName));
        for (Client list: clientList){
            System.out.println(list);
        }
        oleole.stop();
        System.out.println(oleole.getNanoTime());
    }

    public void showTINList1(List<Client> clientList){
        StopWatch oleole=new StopWatch();
        oleole.start();
        clientList.sort(Comparator.comparing(Client::getTaxNumber));
        for (Client list: clientList){
            System.out.println(list);
        }
        oleole.stop();
        System.out.println(oleole.getNanoTime());
    }
}
