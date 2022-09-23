package app.domain.model;

import org.apache.commons.lang3.time.StopWatch;

import java.util.List;

public class Algoritmo1 {



    public void showNameList(List<Client> clientList){
        StopWatch oleole=new StopWatch();
        oleole.start();
        for (int a=1; a< clientList.size(); a++){
            for (int b=0; b< clientList.size()-a;b++ ){
                if ((clientList.get(b)).getName().compareTo(clientList.get(b+1).getName()) > 0){
                    Client client = clientList.get(b);
                    clientList.set(b, clientList.get(b+1));
                    clientList.set(b+1, client);
                }
            }
        }

        for (Client list1: clientList){
            System.out.println(list1);
        }

   oleole.stop();
        System.out.println(oleole.getNanoTime());
    }

    public void showTinList(List<Client> clientList){
        StopWatch oleole=new StopWatch();
        oleole.start();
        for (int a=1; a< clientList.size(); a++){
            for (int b=0; b< clientList.size()-a;b++ ){
                if ((clientList.get(b)).getTaxNumber() > (clientList.get(b+1).getTaxNumber()) ){
                    Client client = clientList.get(b);
                    clientList.set(b, clientList.get(b+1));
                    clientList.set(b+1, client);
                }
            }
        }

        for (Client list1: clientList){
            System.out.println(list1);
        }
        oleole.stop();
        System.out.println(oleole.getNanoTime());
    }
}
