package app.ui.console;

import app.controller.NewTestController;
import app.controller.ParameterCategoryController;
import app.domain.Store.ParameterStore;
import app.domain.model.Company;
import app.domain.model.ParameterCategory;
import app.domain.model.TesteType;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NewTestUI implements Runnable {
    private ParameterCategory pc;
    //Company company = new Company("Many labs");
    //NewTestController controller = new NewTestController();
    //private final ParameterStore store= new ParameterStore();
    private List<ParameterCategory> categories ;



    Scanner ler = new Scanner(System.in);
    private NewTestController newTestController;

    @Override
    public void run() {

        try {
             newTestController=new NewTestController();

             categories=new ArrayList<>();
            int size = newTestController.getNewTestContainer().size();
            System.out.println("Existent types of test in the company :\n");
            System.out.println(newTestController.getNewTestContainer());
            System.out.println("Insert the data needed for the new type of Test");
            System.out.println("Name-");
            String name = ler.nextLine();
            System.out.println("Description-");
            String descriptionTest = ler.nextLine();
            System.out.println("Collecting Methods-");
            String collectingMethods = ler.nextLine();
            System.out.println("Code-");
            String codee = ler.nextLine();


            System.out.println("Existent categories :\n");
            System.out.println(newTestController.getCategoryList());
            System.out.println("\nPlease select the name of the categories that you want to associate to your new type of test or enter 'done' to stop: ");
            String code = ler.nextLine();
            while (!code.equalsIgnoreCase("done")) {
                if (newTestController.getCategoryByCode(code) == null) {
                    System.out.printf("The category [%s] doesn't exist!\n", code);
                    System.out.println("\nPlease select another category code from the list above or enter 'done' to stop: ");
                } else {
                    pc=newTestController.getCategoryByCode(code);
                    categories.add(pc);
                }
                code = ler.nextLine();
            }


            if (newTestController.saveNewTest(newTestController.addNewTest(name, descriptionTest, collectingMethods, codee, categories))) {
                System.out.println("The new test type was saved.");
                } else { System.out.println("The test wasn't saved bop."); }


            System.out.println("\n\t\t|Actualized list of test types|\n");
            System.out.println(this.newTestController.getNewTestContainer());
            System.out.println();


        } catch (IllegalArgumentException iaex) {
            System.out.println(iaex.getMessage());
        } catch (NullPointerException nullPointerException) {
            System.out.println("Invalid data(NULL)!");
        }

    }
}