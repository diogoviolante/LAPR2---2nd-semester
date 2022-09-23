package app.ui.console;

import app.controller.App;
import app.controller.RegisterEmployeeUIController;
import app.domain.model.Company;
import app.domain.model.Employee;
import app.domain.shared.Constants;
import auth.domain.model.Email;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;


public class RegisterEmployeeUI implements Runnable {

    private Employee employee;
    private List<Employee> employeeList = new ArrayList<>();
    RegisterEmployeeUIController controller = new RegisterEmployeeUIController();
    private RegisterEmployeeUIController registerEmployeeUIController;

    public RegisterEmployeeUI() {
        this.registerEmployeeUIController = new RegisterEmployeeUIController();
    }

    private Company company = App.getInstance().getCompany();

    @Override
    public void run() {

        Scanner ler = new Scanner(System.in);


        System.out.println();
        System.out.println();
        String SEP = "------------------------";
        System.out.println(SEP);
        System.out.println("1. " + Constants.ROLE_RECEPTIONIST);
        System.out.println("2. " + Constants.ROLE_LAB_TECHNICIAN);
        System.out.println("3. " + Constants.ROLE_CLINICAL_CHEMISTRY_TECHNOLOGIST);
        System.out.println("4. " + Constants.ROLE_LABORATORY_COORDINATOR);
        System.out.println("5. " + Constants.ROLE_SPECIALIST_DOCTOR);
        System.out.println(SEP);
        System.out.println("Please choose the role of the new employee:");
        String role = ler.nextLine();

        System.out.println("Name:");
        String name = ler.nextLine();
        System.out.println("Address:");
        String address = ler.nextLine();
        System.out.println("Email:");
        String emailString = ler.nextLine();
        Email email = new Email(emailString);
        System.out.println("Phone Number:");
        String phoneNumber = ler.nextLine();
        System.out.println("Standard Occupational Classification (SOC):");
        long soc = ler.nextLong();

        System.out.println();
        System.out.println(SEP);
        System.out.println("Role Number: " + role);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Standard Occupational Classification (SOC): " + soc);
        System.out.println(SEP);
        System.out.println();
        System.out.println("Are you sure that the typed data is correct? YES/NO");
        String resp = ler.nextLine();
        String resp1 = ler.nextLine();
        System.out.println("\n");
        if (resp1.equalsIgnoreCase("yes")) {
            System.out.println(SEP);
            try {
                controller.saveEmployee(controller.roleId(role, name, address, email, phoneNumber, soc));
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Employee created successfully!");
            System.out.println(SEP);
        } else {
            System.out.println(SEP);
            System.out.println("Employee not created");
            System.out.println(SEP);
        }
    }
}

