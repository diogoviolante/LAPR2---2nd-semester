package app.domain.model;

import auth.domain.model.Email;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class ClientTest {
    Client client = new Client("violas", "1234567891234567", 12345678971L, 1234567891L, 1234567891L, new Date("2002/3/30"),  "MALE", new Email("dsviolante@gmail.com"),"yauuuu");

    @Test
    public void validateName() {
        this.client.validateName(this.client.getName());
    }

    @Test (expected = IllegalArgumentException.class)
    public void validateNameBlank() {
        Client client = new Client("", "1234567891234567", 12345678971L, 1234567891L, 1234567891L, new Date("2002/3/30"),  "MALE", new Email("dsviolante@gmail.com"),"yauuuu");
        client.validateName(client.getName());
    }

    @Test  (expected = IllegalArgumentException.class)
    public void validateNameOutLimits() {
        Client client = new Client("asdffimvfdksowefifjdfn sdfsdfdsdsfwef ewfwef", "1234567891234567L", 12345678971L, 1234567891L, 1234567891L, new Date("2002/3/30"),  "MALE", new Email("dsviolante@gmail.com"),"yauuuu");
        client.validateName(client.getName());
    }

    @Test
    public void validateCitizenNumber() {
        this.client.validateCitizenNumber(String.valueOf(this.client.getCitizenNumber()));
    }

    @Test (expected = IllegalArgumentException.class)
    public void validateCitizenNumberOutLimits() {
        Client client = new Client("violas", "1234567891234567894L", 12345678971L, 1234567891L, 1234567891L, new Date("2002/3/30"),  "MALE", new Email("dsviolante@gmail.com"),"yauuuu");
        client.validateCitizenNumber(String.valueOf(client.getCitizenNumber()));
    }

    @Test
    public void validatePhoneNumber() {
        this.client.validatePhoneNumber(String.valueOf(this.client.getPhoneNumber()));
    }

    @Test (expected = IllegalArgumentException.class)
    public void validatePhoneNumberOutLimits() {
        Client client = new Client("violas", "1234567891234567L", 12345678979841L, 1234567891L, 1234567891L, new Date("2002/3/30"),  "MALE", new Email("dsviolante@gmail.com"),"yauuuu");
        client.validatePhoneNumber(String.valueOf(client.getPhoneNumber()));
    }

    @Test
    public void validateNHSNumber() {
        this.client.validateNHSNumber(String.valueOf(this.client.getNhs()));
    }

    @Test (expected = IllegalArgumentException.class)
    public void validateNHSNumberOutLimits() {
        Client client = new Client("violas", "1234567891234567L", 12345678971L, 12345678L, 1234567891L, new Date("2002/3/30"),  "MALE", new Email("dsviolante@gmail.com"),"yauuuu");
        client.validateNHSNumber(String.valueOf(client.getNhs()));
    }

    @Test
    public void validateTIN() {
        this.client.validateTIN(String.valueOf(this.client.getTaxNumber()));
    }

    @Test (expected = IllegalArgumentException.class)
    public void validateTINOutLimits() {
        Client client = new Client("violas", "1234567891234567L", 12345678971L, 1234567891L, 1234567L, new Date("2002/3/30"),  "MALE", new Email("dsviolante@gmail.com"),"yauuuu");
        client.validateTIN(String.valueOf(client.getTaxNumber()));
    }

  /*  @Test
    public void validateRole() {
        this.client.validateRole(this.client.getRole());
    }*/

   /* @Test (expected = IllegalArgumentException.class)
    public void validateRoleBlank() {
        Client client = new Client("violas", 1234567891234567L, 12345678971L, 1234567891L, 1234567891L, new Date("2002/3/30"),  "MALE", new Email("dsviolante@gmail.com"));
        client.validateRole(client.getRole());
    }*/

    @Test
    public void validateGender() {
        this.client.validateGender(this.client.getGender());
    }

    @Test (expected = IllegalArgumentException.class)
    public void validateGenderBlank() {
        Client client = new Client("violas", "1234567891234567L", 12345678971L, 1234567891L, 1234567891L, new Date("2002/3/30"),  "", new Email("dsviolante@gmail.com"),"yauuuu");
        client.validateGender(client.getGender());
    }

    @Test
    public void validateDate() {
        this.client.validateDate(this.client.getBirthDate());
    }

    @Test (expected = IllegalArgumentException.class)
    public void validateDateOutLimits() {
        Client client = new Client("violas", "1234567891234567L", 12345678971L, 1234567891L, 1234567891L, new Date("1550/3/30"),  "MALE", new Email("dsviolante@gmail.com"),"yauuuu");
        client.validateDate(client.getBirthDate());
    }
}