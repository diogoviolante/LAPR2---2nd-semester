package app.domain.Store;
import app.controller.App;
import app.domain.model.Client;
import app.domain.model.Company;
import app.domain.shared.Constants;
import app.domain.shared.ListDates;
import app.domain.shared.ListOfClients;
import auth.AuthFacade;
import auth.domain.model.Email;
import auth.domain.model.Password;

import java.io.*;
import java.util.*;

public class ClientStore implements ListOfClients {

    /**
     * attribute from Company Class.
     */
    private Company company;

    /**
     * attribute from Password Class.
     */
    private String pw;

    public ClientStore(){
        this.company = App.getInstance().getCompany();
    }

    /**
     * Method to create a new client with gender using the Client Class constructor.
     * @param name name of the Client.
     * @param citizenNumber Citizen number of the Client.
     * @param phoneNumber Phone number of the client.
     * @param nhsNumber NHS number of the Client.
     * @param taxNumber Tax Identification number of the Client.
     * @param birthDate Birthdate of the Client.

     * @param gender Gender of the Client.
     * @param email Email of the Client.
     * @return new Client with gender.
     */
    public Client createClientWithGender(String name, String citizenNumber, long phoneNumber, long nhsNumber, long taxNumber, Date birthDate,  String gender, Email email, String adress) {
        try{
            return new Client(name, citizenNumber, phoneNumber, nhsNumber, taxNumber, birthDate, gender, email, adress);
        }catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return new Client(name, citizenNumber, phoneNumber, nhsNumber, taxNumber, birthDate, gender, email, adress);
    }

    /**
     * Method to create a new client using the Client Class constructor.
     * @param name name of the Client.
     * @param citizenNumber Citizen number of the Client.
     * @param phoneNumber Phone number of the client.
     * @param nhsNumber NHS number of the Client.
     * @param taxNumber Tax Identification number of the Client.
     * @param birthDate Birthdate of the Client.
     * @param email Email of the Client.
     * @return new Client.
     */
    public Client createClient(String name, String citizenNumber, long phoneNumber, long nhsNumber, long taxNumber, Date birthDate,  Email email, String adress) {
        try{
            return new Client(name, citizenNumber, phoneNumber, nhsNumber, taxNumber, birthDate,  email, adress);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return new Client(name, citizenNumber, phoneNumber, nhsNumber, taxNumber, birthDate,  email, adress);
    }

    /**
     * Method to save the Client created.
     * @param newClient client created in createClient.
     */
    public void saveClient(Client newClient) {
        if(validateClient(newClient)) {
            clientList.add(newClient);
            this.pw = Password.generatePW(10);

            if (company.getAuthFacade().addUserWithRole(newClient.getName(), newClient.getEmail().toString(), this.pw, Constants.ROLE_CLIENT)){
               System.out.println("Clients registred in the system:");
                for (Client clients : clientList) {
                    System.out.println(clients.getNhs());
                }
                System.out.println("Operation was successful!");
            }


            try {
                this.generateMessage(newClient.getEmail(), newClient.getName());
            } catch (IOException e) {
                e.printStackTrace();
            }

       }
    }
    public void saveClient2(Client newClient) {
        if(validateClient(newClient)) {
            clientList.add(newClient);
            this.pw = Password.generatePW(10);
            //int counter=0;
            if (company.getAuthFacade().addUserWithRole(newClient.getName(), newClient.getEmail().toString(), this.pw, Constants.ROLE_CLIENT)){
                //System.out.println("Clients registred in the system:");

                for (Client clients : clientList) {
                 //counter=counter+1;
                  // System.out.println(clients.getNhs());
                }

                //System.out.println("Operation was successful!");
            }

            //System.out.println(counter);

            try {
                this.generateMessage(newClient.getEmail(), newClient.getName());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    /**
     * Method to validate the client created.
     * @param newClient new Client created.
     */
    public boolean validateClient (Client newClient) {
        if (newClient == null) {
            return false;
        } else {
            for (Client clientCheck : clientList) {
                if (clientCheck.getCitizenNumber()== newClient.getCitizenNumber() || clientCheck.getPhoneNumber() == newClient.getPhoneNumber()
                || clientCheck.getNhs() == newClient.getNhs() || clientCheck.getTaxNumber() == newClient.getTaxNumber() || clientCheck.getEmail()==newClient.getEmail()) {
                    throw new IllegalArgumentException("One of the Client's attributes already exist in our database. Please verify the information you entered.");
                }
            }
        }
        return !this.clientList.contains(newClient);
    }

    /**
     * Method to generate the message with the new client's password.
     * @param email Client's email.
     * @param name Client's name.
     */
    public void generateMessage (Email email, String name) throws IOException {
        File file = new File("OutputFiles\\Clients\\emailAndSMSMessages"+email+".txt");
        PrintWriter print = null;

        try{
            print = new PrintWriter(new FileWriter(file));
            print.append("Client: ").append(name);
            print.append("\nEmail: ").append(String.valueOf(email));
            print.append("\nPassword: ").append(this.pw.toString());
            print.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            print.close();
        }




    }

    /**
     * method to get a client with a Tax Identification Number.
     * @param taxNumber Tax Identification Number
     * @return correspondent client
     */
    public static Client getClient(Long taxNumber) {
        Client client = null;
        for (Client clients : clientList) {
            if (taxNumber.equals(clients.getTaxNumber())) {
                client = clients;
            }
        }
        return client;
    }

    /**
     * method to get the list of clients.
     * @return clientList
     */
    public List<Client> getClientList() {
        return clientList;
    }
}