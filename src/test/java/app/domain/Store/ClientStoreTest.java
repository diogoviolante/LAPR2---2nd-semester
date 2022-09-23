package app.domain.Store;

import app.domain.model.Client;
import auth.domain.model.Email;
import auth.domain.model.Password;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class ClientStoreTest {
    ClientStore clientStore = new ClientStore();
    Client client = new Client("violas", "1234567891234567", 12345678971L, 1234567891L, 1234567891L, new Date("2002/3/30"), "MALE", new Email("dsviolante@gmail.com"), "yauuuu");
    Client client1 = new Client("violas", "1234567891234567", 12345678971L, 1234567891L, 1234567891L, new Date("2002/3/30"), "MALE", new Email("dsviolante@gmail.com"), "yauuuu");
    Client client2 = new Client("pops", "8789878987898785", 12345879457L, 1234578468L, 1234578546L, new Date("2002/4/30"), "MALE", new Email("epah@isep.pt"), "kkkkkkkkk");
    List<Client> clients = new ArrayList<>();

    @Test
    public void createClientWithGenderRight() { this.clientStore.createClientWithGender("violas", "1234567891234567", 12345678971L, 1234567891L, 1234567891L, new Date("2002/3/30"), "MALE", new Email("dsviolante@gmail.com"), "yauuuu"); }
    @Test(expected = IllegalArgumentException.class)
    public void createClientWithGenderWrong1() { this.clientStore.createClientWithGender("violas", "12345678912345", 12345678971L, 1234567891L, 1234567891L, new Date("2002/3/30"),  "MALE", new Email("dsviolante@gmail.com"),"yauuuu"); }
    @Test(expected = IllegalArgumentException.class)
    public void createClientWithGenderWrong2() { this.clientStore.createClientWithGender("violas", "1234567891234567", 1234567897L, 1234567891L, 1234567891L, new Date("2002/3/30"),  "MALE", new Email("dsviolante@gmail.com"),"yauuuu"); }
    @Test(expected = IllegalArgumentException.class)
    public void createClientWithGenderWrong3() { this.clientStore.createClientWithGender("violas", "1234567891234567", 12345678971L, 123456789L, 1234567891L, new Date("2002/3/30"),  "MALE", new Email("dsviolante@gmail.com"),"yauuuu"); }
    @Test(expected = IllegalArgumentException.class)
    public void createClientWithGenderWrong4() { this.clientStore.createClientWithGender("violas", "1234567891234567", 12345678971L, 1234567891L, 123456789L, new Date("2002/3/30"),  "MALE", new Email("dsviolante@gmail.com"),"yauuuu"); }
    @Test(expected = IllegalArgumentException.class)
    public void createClientWithGenderWrong5() { this.clientStore.createClientWithGender("qwertyuiopasdfghjklçzxcvbnmklçpokijuh", "1234567891234567", 12345678971L, 1234567891L, 1234567891L, new Date("2002/3/30"), "MALE", new Email("dsviolante@gmail.com"),"yauuuu"); }
    @Test(expected = IllegalArgumentException.class)
    public void createClientWithGenderWrong6() { this.clientStore.createClientWithGender("", "1234567891234567", 12345678971L, 1234567891L, 1234567891L, new Date("2002/3/30"),  "MALE", new Email("dsviolante@gmail.com"),"yauuuu"); }
    @Test(expected = IllegalArgumentException.class)
    public void createClientWithGenderWrong8() { this.clientStore.createClientWithGender("violas", "1234567891234567", 12345678971L, 1234567891L, 1234567891L, new Date("2002/3/30"),  "", new Email("dsviolante@gmail.com"),"yauuuu"); }
    @Test(expected = IllegalArgumentException.class)
    public void createClientWithGenderWrong9() { this.clientStore.createClientWithGender("violas", "1234567891234567L", 12345678971L, 1234567891L, 1234567891L, new Date("1800/3/30"),  "MALE", new Email("dsviolante@gmail.com"),"yauuuu"); }
    @Test(expected = IllegalArgumentException.class)
    public void createClientWithGenderWrong10() { this.clientStore.createClientWithGender("violas", "1234567891234567", 12345678971L, 1234567891L, 1234567891L, new Date("2002/3/30"),  "MALE", new Email(""),"yauuuu"); }
    @Test
    public void creatClient() { this.clientStore.createClient("violas", "1234567891234567", 12345678971L, 1234567891L, 1234567891L, new Date("2002/3/30"), new Email("dsviolante@gmail.com"),"yauuuu"); }
    @Test(expected = IllegalArgumentException.class)
    public void createClientWrong1() { this.clientStore.createClient("violas", "12345678912345", 12345678971L, 1234567891L, 1234567891L, new Date("2002/3/30") , new Email("dsviolante@gmail.com"),"yauuuu"); }
    @Test(expected = IllegalArgumentException.class)
    public void createClientWrong2() { this.clientStore.createClient("violas", "1234567891234567", 1234567897L, 1234567891L, 1234567891L, new Date("2002/3/30"),  new Email("dsviolante@gmail.com"),"yauuuu"); }
    @Test(expected = IllegalArgumentException.class)
    public void createClientWrong3() { this.clientStore.createClient("violas", "1234567891234567", 12345678971L, 123456789L, 1234567891L, new Date("2002/3/30"),  new Email("dsviolante@gmail.com"),"yauuuu"); }
    @Test(expected = IllegalArgumentException.class)
    public void createClientWrong4() { this.clientStore.createClient("violas", "1234567891234567", 12345678971L, 1234567891L, 123456789L, new Date("2002/3/30"),  new Email("dsviolante@gmail.com"),"yauuuu"); }
    @Test(expected = IllegalArgumentException.class)
    public void createClientWrong5() { this.clientStore.createClient("qwertyuiopasdfghjklçzxcvbnmklçpokijuh", "1234567891234567L", 12345678971L, 1234567891L, 1234567891L, new Date("2002/3/30"),  new Email("dsviolante@gmail.com"),"yauuuu"); }
    @Test(expected = IllegalArgumentException.class)
    public void createClientWrong6() { this.clientStore.createClient("", "1234567891234567", 12345678971L, 1234567891L, 1234567891L, new Date("2002/3/30"),  new Email("dsviolante@gmail.com"),"yauuuu"); }
    @Test(expected = IllegalArgumentException.class)
    public void createClientWrong8() { this.clientStore.createClient("violas", "1234567891234567", 12345678971L, 1234567891L, 1234567891L, new Date("1800/3/30"),  new Email("dsviolante@gmail.com"),"yauuuu"); }
    @Test(expected = IllegalArgumentException.class)
    public void createClientWrong9() { this.clientStore.createClient("violas", "1234567891234567", 12345678971L, 1234567891L, 1234567891L, new Date("2002/3/30"),  new Email(""),"yauuuu"); }

    @Test
    public void validateClientRigth() { assertTrue(this.clientStore.validateClient(this.clientStore.createClient("violas", "1234567891234567", 12345678971L, 1234567891L, 1234567891L, new Date("2002/3/30"),  new Email("dsviolante@gmail.com"),"yauuuu"))); }




    @Test
    public void validateClient() { clientStore.validateClient(client); }
    @Test
    public void validateClient1() { clientStore.validateClient(null); }

    @Test(expected = IllegalArgumentException.class)
    public void validateClient2() { assertTrue(this.clientStore.validateClient(this.clientStore.createClient("uuuuuuuuuuuuuuuuuuuuuuu", "11111", 12345L, 12345L, 12345L, new Date(),  new Email("epah@isep.pt"), "kkkkkkkkk"))); }
    @Test(expected = IllegalArgumentException.class)
    public void validateClient3() { assertTrue(this.clientStore.validateClient(this.clientStore.createClient("uuuuuuuuuuuuuuuuuuuuuuu", "1234567891234567", 12345L, 12345L, 12345L, new Date(),  new Email("epah@isep.pt"), "kkkkkkkkk"))); }
    @Test(expected = IllegalArgumentException.class)
    public void validateClient4() { assertTrue(this.clientStore.validateClient(this.clientStore.createClient("uuuuuuuuuuuuuuuuuuuuuuu", "1234567891234567", 12345678912L, 12345L, 12345L, new Date(),  new Email("epah@isep.pt"), "kkkkkkkkk"))); }
    @Test(expected = IllegalArgumentException.class)
    public void validateClient5() { assertTrue(this.clientStore.validateClient(this.clientStore.createClient("uuuuuuuuuuuuuuuuuuuuuuu", "1234567891234567", 12345678912L, 1234567891L, 12345L, new Date(),  new Email("epah@isep.pt"), "kkkkkkkkk"))); }
    @Test(expected = IllegalArgumentException.class)
    public void validateClient6() { assertTrue(this.clientStore.validateClient(this.clientStore.createClient("uuuuuuuuuuuuuuuuuuuuuuu", "1234567891234567", 12345678912L, 1234567891L, 1234567891L, new Date("20"),  new Email("epah@isep.pt"), "kkkkkkkKKKKkkKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK"))); }





    String pw = Password.generatePW(10);
    @Test
    public void generateMessage() {
        Email email = new Email("pabloescobar@gmail.com");
        String name = "Pablo Escobar";
        File file = new File("Clients\\emailAndSMSMessages"+email+".txt");
        try (PrintWriter print = new PrintWriter(new FileWriter(file))) {
            print.append("Client: ").append(name);
            print.append("\nEmail: ").append(String.valueOf(email));
            print.append("\nPassword: ").append(this.pw);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Test
    public void getClientList() {
        Long taxNumber = 1234567891L;
        List<Client> arr = clientStore.getClientList();
        Boolean result = taxNumber.equals(client.getTaxNumber());
    }



    @Test
    public void saveClient() { clientStore.saveClient(client); }



    @Test
    public void saveClient2() { clientStore.saveClient2(client2); }




}