package app.controller;

import app.domain.model.Company;
import app.domain.model.Employee;
import auth.domain.model.Email;
import auth.domain.model.Password;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class RegisterEmployeeUIController {

    private Company company;
    private Employee employee;
    private List<Employee> employeeList = new ArrayList<>();

    public RegisterEmployeeUIController() {
        this(App.getInstance().getCompany());
    }

    public RegisterEmployeeUIController(final Company company) {
        this.company = company;
        this.employee = null;
    }

    /**
     * Cria um Employee
     */
    public Employee creatEmployee(final String role, final String employeeID, final String name, final String address, final Email email, final String phoneNumber, final long soc) throws Exception {
       return this.employee = company.creatEmployee(role, employeeID, name, address, email, phoneNumber, soc);
    }

    /**
     * Cria um Specialist Doctor
     */
    public Employee creatEmployeeSpecialistDoctor(final String role, final String employeeID, final String name, final String address, final Email email, final String phoneNumber, final long soc, final long indexNumber) throws Exception {
        return this.employee = company.creatSpecialistDoctor(role, employeeID, name, address, email, phoneNumber, soc, indexNumber);
    }

    public boolean registEmployee(String readerEmployeeID, String readerRoleID, String readerName, String readerAddress,String  readerPhoneNumber,String readerEmail, long readerSoc){
        return this.registEmployee(readerEmployeeID, readerRoleID, readerName, readerAddress, readerPhoneNumber, readerEmail, readerSoc);
    }


    public  Employee roleId (String role, String name, String address, Email email, String phoneNumber, Long soc) throws Exception {

        String nameId = this.generateID(name);

     if (role.equals("5")  || role.equalsIgnoreCase("Specialist Doctor") || role.equalsIgnoreCase("5. Specialist Doctor") || role.equalsIgnoreCase("Doctor")) {
          role = "Specialist Doctor";
          System.out.println();
          System.out.println("Please type the Index Number of the Specialist Doctor");
          System.out.println("Index Number:");
          Scanner ler = new Scanner(System.in);
          long indexNumber = ler.nextLong();
          return this.creatEmployeeSpecialistDoctor(role, nameId, name, address, email, phoneNumber, soc, indexNumber);
     } else if (role.equals("1")  || role.equalsIgnoreCase("Receptionist") || role.equalsIgnoreCase("1. Receptionist")) {
          role = "Receptionist";
          return this.creatEmployee(role, nameId , name, address, email, phoneNumber, soc);
     } else if (role.equals("2")  || role.equalsIgnoreCase("Lab Technician") || role.equalsIgnoreCase("2. Lab Technician") || role.equalsIgnoreCase("Technician")) {
          role = "Lab Technician";
          return this.creatEmployee(role, nameId, name, address, email, phoneNumber, soc);
     } else if (role.equals("3")  || role.equalsIgnoreCase("Clinical Chemistry Technologist") || role.equalsIgnoreCase("3. Clinical Chemistry Technologist") || role.equalsIgnoreCase("Chemistry Technologist") || role.equalsIgnoreCase("Technologist")) {
          role = "Clinical Chemistry Technologist";
          return this.creatEmployee(role, nameId, name, address, email, phoneNumber, soc);
     } else if (role.equals("4")  || role.equalsIgnoreCase("Laboratory Coordinator") || role.equalsIgnoreCase("4. Laboratory Coordinator") || role.equalsIgnoreCase("Coordinator")) {
          role = "Laboratory Coordinator";
          return this.creatEmployee(role, nameId, name, address, email, phoneNumber, soc);
     }
        return null;
    }



    /**
     * Auxiliar variable
     */
    private int count = 1;



    /**
     * Gera o ID do Employee.
     *
     * @return employeeID do Employee
     */
    public String generateID(String name) {
        int max = 100000;
        String empID = "";


        count = count % max;
        String numEmp = String.valueOf(count);
        while (numEmp.length() < 5) {
            numEmp = "0" + numEmp;
        }


        String[] id = name.split(" ");
        for (String s : id) {
            empID = empID + String.valueOf(s.toUpperCase().charAt(0));
        }
        empID = empID + numEmp;

        count++;
        System.out.println("Name Id: " + empID);
        return empID;
    }


    public void saveEmployee(Employee employee){
       this.company.saveEmployee(employee);
    }






}


