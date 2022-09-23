package app.ui.console;

import app.controller.CreateClientController;
import app.domain.model.Client;
import app.domain.model.Company;
import app.domain.shared.Constants;
import auth.UserSession;
import auth.domain.model.Email;

import java.io.IOException;
import java.util.*;

public class CreateClientUI implements Runnable{
    private List<Client> clientList = new ArrayList<>();
    private CreateClientController createClientController = new CreateClientController();


    @Override
    public void run() {


        Scanner ler = new Scanner(System.in);

        System.out.println("Please insert the data needed to register a new client.");
        System.out.println("Name:");
        String name = ler.nextLine();
        System.out.println("Citizen card number:");
        String citizenNumber = ler.nextLine();
        System.out.println("Phone number:");
        long phoneNumber = ler.nextLong();
        System.out.println("NHS  number:");
        long nhsNumber = ler.nextLong();
        System.out.println("Tax Identification Number:");
        long taxNumber = ler.nextLong();

        System.out.println("Birthdate: (year)");
        int birthYear = ler.nextInt();
        System.out.println("Birthdate: (month)");
        int birthMonth = ler.nextInt()-1;
        System.out.println("Birthdate: (day)");
        int birthDay = ler.nextInt();
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(Calendar.YEAR, birthYear);
        cal.set(Calendar.MONTH, birthMonth);
        cal.set(Calendar.DAY_OF_MONTH, birthDay);
        Date birthDate = cal.getTime();

        System.out.println("User address:");
        String adress0 = ler.nextLine();
        String adress = ler.nextLine();
        System.out.println("Email:");
        String emailString = ler.nextLine();
        Email email = new Email(emailString);

        System.out.println("Do you wish o add gender? (YES/NO)");
        if (ler.nextLine().equalsIgnoreCase("YES")) {
            System.out.println("Insert gender.");
            String gender = ler.nextLine();
            try {
                createClientController.saveClient( createClientController.createClientWithGender(name, citizenNumber, phoneNumber, nhsNumber, taxNumber, birthDate, gender, email,adress));
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            try {
                createClientController.saveClient( createClientController.createClient(name, citizenNumber, phoneNumber, nhsNumber, taxNumber, birthDate, email, adress));
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
