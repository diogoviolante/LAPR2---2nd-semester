package app.ui.console;

import app.controller.CreateClinicalAnalysisLabController;
import app.controller.NewTestController;
import app.domain.model.ClinicalAnalysisLaboratory.ClinicalAnalysisLaboratory;
import app.domain.model.Company;
import app.domain.model.TesteType;
import app.domain.model.ParameterCategory;
import app.domain.shared.ClinicalAnalysisLaboratories;
import app.domain.shared.ListOfTypes;
import app.dto.CreateAnalysisClinicalLabDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateClinicalAnalysisLabUI implements Runnable, ListOfTypes {
    static Scanner ler = new Scanner(System.in);
    private Company company= new Company("Many Labs");
    private CreateClinicalAnalysisLabController controller= new CreateClinicalAnalysisLabController();
    private CreateAnalysisClinicalLabDTO dto;
    private List<TesteType> NewTestContainer= company.getNewTestContainer();
    NewTestController newTestController= new NewTestController(company);
    int index;
    boolean checkerInvalid = true;



    @Override
    public void run(){
        company = new Company("Many Labs");
        controller = new CreateClinicalAnalysisLabController(company);
        do {
            System.out.println("Laboratory ID: ");
            String laboratoryID = ler.nextLine();
            System.out.println("Laboratory name: ");
            String name = ler.nextLine();
            System.out.println("Laboratory address: ");
            String address = ler.nextLine();
            System.out.println("Laboratory phone number: ");
            String phone_Number = ler.nextLine();
            System.out.println("Laboratory TIN Number: ");
            String tin_Number = ler.nextLine();
           //
            System.out.println("Insert the index o the test type you want:");
            int[] array = new int[10];
            do {
                int i=0;
                for (TesteType yau: listTypes){
                    i++;
                    System.out.println(i+". "+yau);
                }
                index = ler.nextInt();
                ler.nextLine();
                System.out.println("0 - If you want to exit!");
                if (index!=0) {
                    if (array[index] == 1) {

                        while(array[index]==1){
                            System.out.println("This test type has been already added");
                            System.out.println("Please type another test");
                            index = ler.nextInt();
                            if (index==-1)break;
                        } while (array[index]==1);
                        array[index] = 1;
                    }array[index] = 1;
                }
                System.out.println();
            } while (index != 0);
            try {
                dto = new CreateAnalysisClinicalLabDTO(laboratoryID, name, address, phone_Number, tin_Number, company.getNewTestContainer());
                controller.createClinicalAnalysisLab(dto);
                checkerInvalid = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }while (checkerInvalid);

        System.out.printf("Are you sure that you added all %s required tests?(Yes/No)", company.getDesignation());
        String resposta= ler.next();
        if (resposta.equalsIgnoreCase("Yes")){
            controller.saveClinicalAnalysisLab();
            System.out.println("You have successfully added a new Clinical Analysis Laboratory");
        }else{
            System.out.println("Operation failed");
        }
    }






}
