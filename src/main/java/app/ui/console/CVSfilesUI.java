package app.ui.console;

import app.controller.CVSfilesController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class CVSfilesUI implements Runnable {
private Scanner ler= new Scanner(System.in);
private CVSfilesController controller;
private int option;
    @Override
    public void run() {
        CVSfilesController controller= new CVSfilesController();
        System.out.println("Chose the file that you want to import (1/2/3)");
option=ler.nextInt();


        try {
            controller.choseOption(option);
           // controller.CreateClient(option);
            controller.AddTest(option);
          //  System.out.println(controller.getTestList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
