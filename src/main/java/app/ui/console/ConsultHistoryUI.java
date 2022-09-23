package app.ui.console;

import app.controller.ConsultHistoryController;
import app.domain.model.*;
import app.domain.shared.ListOfClients;
import app.domain.shared.PastTests;

import java.io.IOException;
import java.util.Scanner;


public class ConsultHistoryUI implements Runnable, PastTests, ListOfClients {
    private ConsultHistoryController controller= new ConsultHistoryController();
    private Scanner ler = new Scanner(System.in);
    private Company company;
    private Long TinNumber;
    private String code;
    private int index;
    private Algoritmo1 algoritmo1;
    private Algoritmo2 algoritmo2;


    @Override
    public void run() {
        company = new Company("ManyLabs");
        for (Client lista: clientList){
            System.out.println(lista);
        }

        if (controller.checkAlgorithm1()==null){
            try {
                controller.getAlgoritmo2();
                System.out.println(clientList.size());
            } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }else if (controller.checkAlgorithm2()==null){
            try {
                controller.getAlgoritmo1();
                System.out.println(clientList.size());
            } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        controller.chooseTest();
    }
}
