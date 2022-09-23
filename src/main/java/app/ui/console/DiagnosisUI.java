package app.ui.console;

import app.controller.DiagnosisController;
import app.domain.model.Company;
import app.domain.model.Test;
import app.domain.shared.ListofTests;

import java.util.Date;
import java.util.Scanner;

public class DiagnosisUI implements Runnable, ListofTests {
    Scanner ler = new Scanner(System.in);
    Company company = new Company("Many labs");
    private final DiagnosisController diagnosisController;
    private Date date = new Date();
    public DiagnosisUI() {
        this.diagnosisController = new DiagnosisController();
    }
    private String code;

    @Override
    public void run() {
        try {
            System.out.println(diagnosisController.getDiagnosisList());
            int size = diagnosisController.getDiagnosisList().size();
            //meter aqui a lista de testes do violante para escolher o teste para dar report
            int boolea =0;
            do {
                System.out.println("Insert Tax Identification number.");
            Long tin = ler.nextLong();
            for (Test listTest : listOfTests) {
               if (tin.equals(listTest.getClient().getTaxNumber())) {
                   code = listTest.getCode();
                }
            }



                try{
                    if (code==null){
                        throw new IllegalArgumentException();
                    }
                    boolea =1;
                }catch (IllegalArgumentException i){
                    System.out.println("The given code does not match any client's test.");
                }
            }while(boolea==0);

            System.out.println("Insert the report text");
            String report = ler.nextLine();
            String report1 = ler.nextLine();
            if (this.diagnosisController.getDiagnosis(report1,date, code)) {
                if (this.diagnosisController.saveDiagnosis(code)) {
                    System.out.println("The report was saved sucessfully");
                } else {
                    System.out.println("The report wasn't saved");
                }

            } else {
                System.out.println("The report wasn't saved");
            }
            if (diagnosisController.getDiagnosisList().size() == size) {
                System.out.println("Error, it wasn't added any report to the test");
            }

        } catch (IllegalArgumentException iaex) {
            System.out.println(iaex.getMessage());
        } catch (NullPointerException nullPointerException) {
            System.out.println("Invalid data(NULL)!");
        }

    }
}
