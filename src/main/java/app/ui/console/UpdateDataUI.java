package app.ui.console;

import app.controller.App;
import app.domain.model.Client;
import app.domain.model.Company;
import auth.domain.model.Email;
import java.util.List;
import java.util.Scanner;

public class UpdateDataUI implements Runnable {
    private Company company = App.getInstance().getCompany();
    private List<Client> clientList = company.getClientList();
    private Client client1;
    private Scanner sc = new Scanner(System.in);

    @Override
    public void run() {
        Email email = this.company.getAuthFacade().getCurrentUserSession().getUserId();
        for (Client client: clientList) {
            if (client.getEmail().equals(email)) {
                client1 = client;
            }
        }

        int option2;
        do {
            System.out.println(client1.toString());
            System.out.println("What data do you wish to update?" +
                    "\n1-Name" +
                    "\n2-Phone Number" +
                    "\n3-Gender" +
                    "\n4-Address");

            int option = sc.nextInt();

            if (option == 1) {
                System.out.println("Introduce the new Name");
                sc.nextLine();
                String name = sc.nextLine();
                this.client1.setName(name);
            }else if (option == 2) {
                System.out.println("Introduce the new Phone Number");
                Long phoneNumber = sc.nextLong();
                this.client1.setPhoneNumber(phoneNumber);
            }else if (option == 3) {
                if (this.client1.getGender() != null) {
                    System.out.println("Introduce the new Gender");
                    String gender = sc.next();
                    this.client1.setGender(gender);
                } else
                    System.out.println("The user has no gender attributed.");
            }else if (option ==4){
                System.out.println("Introduce the new Address");
                String address = sc.next();
                this.client1.setAddress(address);
            }
            System.out.println(client1.toString());
            System.out.println("Do you wish to update more Data?" +
                    "\n1-Yes" +
                    "\n0-No");
            option2 = sc.nextInt();

        } while (option2 == 1);

    }
}
