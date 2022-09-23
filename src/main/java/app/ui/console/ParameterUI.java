package app.ui.console;

import app.controller.ParameterCategoryController;
import app.controller.ParameterController;
import app.domain.model.Company;
import app.domain.model.Parameter;
import app.domain.model.ParameterCategory;
import app.ui.console.utils.Utils;

import java.util.List;
import java.util.Scanner;

public class ParameterUI implements Runnable {
    Company company = new Company("Many labs");
    private final ParameterController parameterController;
    private final ParameterCategoryController parameterCategoryController;
    Scanner ler = new Scanner(System.in);
    private boolean boo = false;
    private ParameterCategory parameterCategory;
    public ParameterUI() {

        this.parameterController = new ParameterController();
        this.parameterCategoryController = new ParameterCategoryController();
    }

    @Override
    public void run() {
        try {
            int size = parameterController.getParamterList().size();
            List<ParameterCategory> parameterCategories = parameterCategoryController.getParameterCategoryList();
            System.out.println("Existent parameters in the store :\n");
            System.out.println(parameterController.getParamterList());
            System.out.println("Insert the data nedded for the parameter");
            System.out.println("Insert name");
            String shortName = ler.nextLine();
            System.out.println("Insert description");
            String description = ler.nextLine();
            System.out.println("Chose category (name)");
            System.out.println(parameterController.getControllerCategoryList());
            String name = ler.nextLine();
            do {
                try {
                    if (this.parameterCategoryController.getParameterCategoryByName(name) == null) {
                        throw new IllegalArgumentException("There is no category with that name");
                    }
                    boo = true;
                } catch (IllegalArgumentException e) {
                    boo = false;
                    e.printStackTrace();
                }
            } while (!boo);
            this.parameterCategory=this.parameterCategoryController.getParameterCategoryByName(name) ;
            System.out.println("Insert code");
            String paramtercode = ler.next();
            ler.nextLine();
            if (this.parameterController.createParameter(paramtercode, shortName, description, name)) {
                if (this.parameterController.saveParameter()) {
                    System.out.println("The new paramter was saved");
                } else {
                    System.out.println("The parameter wasnt saved");
                }

            } else {
                System.out.println("The  parameter wasnt saved");
            }
            if (parameterController.getParamterList().size() == size) {
                System.out.println("Error. It wasn't added any parameter to the list.\n");
            }


        }catch (IllegalArgumentException iaex) {
            System.out.println(iaex.getMessage());
        } catch (NullPointerException nullPointerException){
            System.out.println("Invalid data(NULL)!");
        }


    }

}
