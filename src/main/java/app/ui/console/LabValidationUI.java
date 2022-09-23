package app.ui.console;

import app.controller.LabCoordinatorController;

import app.controller.RegisterResultController;
import app.domain.model.Results;
import app.domain.Store.DiagnosisStore;
import app.domain.model.*;
import app.domain.shared.*;
import app.dto.validationCoordinatorDto;
import app.ui.console.utils.Utils;
import auth.domain.model.Email;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class LabValidationUI implements Runnable, ListDates, validTests, ListofTests,PastTests {

    private Scanner ler = new Scanner(System.in);
    private boolean check;
    private DiagnosisStore d = new DiagnosisStore();
    private Results r;
    private Long testCode;
    private String index_list;
    private Company company;
    private int index_int;
    private LabCoordinatorController controller = new LabCoordinatorController();
    private int count;
    private String code;
    private RegisterResultController contr = new RegisterResultController();
    private Email email;
    private Test test;


    @Override
    public void run() {
        try {

            company = new Company("ManyLabs");
            /*
            lista.add("yau");
            param.add("parametros");

            Client client= new Client("Rodrigo",1234567891234567L,12345678911L,1234567891L,1234567891L,new Date("27/05/2002"),"Client", new Email("123@yau.com"));
            TesteType tt= new TesteType("cenas","blood","swab",12345,lista);
            Client client2= new Client("yau",1234567891234568L,12345678912L,1234567891L,1234567892L,new Date("23/02/1997"),"Client", new Email("123@yauyau.com"));
            Test test= new Test(client,123456789111L, "123456789111", "cenas", lista, param, 12425, new Date());
*/

            System.out.println("Please insert the code of the test.");
            code = ler.next();

            for (AllDates dates1 : datesList) {
                System.out.println(dates1.toString());


                count = 0;
                for (AllDates dates : datesList) {
                    if (dates.getCode().equals(code)) {
                        if (dates.getDate() != null)
                            count++;
                    }
                }

                for (Test yau : listOfTests) {
                    if (yau.getCode().equals(code)) {
                        test = yau;
                        email = yau.getClient().getEmail();
                    }
                }


                if (count == 4 || count == 11) {
                    validTests.add(test);
                    System.out.println();
                    for (Test validtestes : validTests)
                        System.out.println("Do you want to validate this test?");
                    System.out.println("\n1. Yes \n2. No");
                    String input = ler.next();

                    if (input.equals(("1"))) {
                        controller.AddValidationCoordinator(test);

                        System.out.println("Operation successful");
                        File log = new File("C:\\Users\\Carrusca\\Documents\\lei-21-s2-1df-g25\\OutputFiles\\files\\files" + code + ".txt");
                        try {
                            if (!log.exists()) {
                                System.out.println("We had to make a new file.");
                                log.createNewFile();
                            }
                            PrintWriter out = new PrintWriter(new FileWriter(log, true));
                            out.append("\n Email : " + email + "\n Your test : " + code + " is now available for you to check!\n");
                            out.close();
                        } catch (IOException e) {
                            System.out.println("COULD NOT LOG!!");
                        }
                    } else {
                        System.out.println("Operation cancelled");
                    }
                } else {
                    System.out.println("There aren't enough dates to continue.");
                }
                count = 0;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}