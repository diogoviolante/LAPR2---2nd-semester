package app.ui.console;

import app.controller.ParameterCategoryController;
import app.domain.model.Company;

import java.util.Scanner;

public class CreateParameterCategoryUI implements Runnable {
    private Scanner ler = new Scanner(System.in);
    private String code;
    private String name;
    private Company company;
    private String checker;


    public void run() {
        company = new Company("Many labs");
        ParameterCategoryController controller= new ParameterCategoryController(company);
        do {
        System.out.println("Code: ");
        code = ler.nextLine();
        System.out.println("Name: ");
        name = ler.nextLine();



            System.out.println("Do you confirm this data?");
            System.out.println("Parameter Category: Code= " + code + " " + "Name= " + name);
            System.out.println("1- Yes");
            System.out.println("2- No");
            checker=ler.nextLine();
        } while (!((checker.equals("1") || (checker.equals("2")))));
            if (checker.equals("1")) {
                controller.createParameterCategory(code, name);
                System.out.println("New Parameter Category created successfully!");
                controller.saveParameterCategory();
                System.out.println("New Parameter Category saved successfully!");
                System.out.println("Operation successfull");
            } else System.out.println("Operation Uncessful");
        System.out.println(company.getParameterCategoryList());
    }
}