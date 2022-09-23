package app.domain.model;

import app.domain.shared.Constants;
import auth.domain.model.Email;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Client implements Serializable {
    /**
     * Client's name.
     */
    private String name;
    /**
     * Client's citizen number.
     */
    private String citizenNumber;
    /**
     * Client's phone number.
     */
    private long phoneNumber;
    /**
     * Client's NHS number.
     */
    private long nhsNumber;
    /**
     * Client's Tax Identification number.
     */
    private long taxNumber;
    /**
     * Client's birthdate.
     */
    private Date birthDate;
    /**
     * Client's role.
     */
    private String role;
    /**
     * Client's gender.
     */
    private String gender;
    /**
     * Client's email.
     */
    private Email email;
    private String address;
    /**
     * Constructor of Client Class.
     * @param name name of the Client.
     * @param citizenNumber Citizen number of the Client.
     * @param phoneNumber Phone number of the client.
     * @param nhsNumber NHS number of the Client.
     * @param taxNumber Tax Identification number of the Client.
     * @param birthDate Birthdate of the Client.

     * @param gender Gender of the Client.
     * @param email Email of the Client.
     */
    public Client(String name, String citizenNumber, long phoneNumber,  long nhsNumber, long taxNumber, Date birthDate, String gender, Email email,String address) {

        setName(name);
        setCitizen(citizenNumber);
        setPhoneNumber(phoneNumber);
        setNhs(nhsNumber);
        setTaxNumber(taxNumber);
        setBirthDate(birthDate);
        setGender(gender);
        setEmail(String.valueOf(email));
        setAddress(address);
    }

    /**
     * Constructor of Client Class.
     * @param name name of the Client.
     * @param citizenNumber Citizen number of the Client.
     * @param phoneNumber Phone number of the client.
     * @param nhsNumber NHS number of the Client.
     * @param taxNumber Tax Identification number of the Client.
     * @param birthDate Birthdate of the Client.

     * @param email Email of the Client.
     */




    public Client(String name, String citizenNumber, long phoneNumber,  long nhsNumber, long taxNumber, Date birthDate,  Email email,String address) {

        setName(name);
        setCitizen(citizenNumber);
        setPhoneNumber(phoneNumber);
        setNhs(nhsNumber);
        setTaxNumber(taxNumber);
        setBirthDate(birthDate);
        setEmail(String.valueOf(email));
        setAddress(address);
    }

    /**
     * method to get the Client's name.
     * @return Client's name.
     */
    public String getName() {
        return name;
    }

    /**
     * method to get the Client's Citizen number.
     * @return Client's citizen number.
     */

    public String getCitizenNumber() {
        return citizenNumber;
    }

    /**
     * method to get the Client's phone number.
     * @return Client's phone number.
     */
    public long getPhoneNumber() { return phoneNumber; }

    /**
     * method to get the Client's NHS number.
     * @return Client's NHS number.
     */
    public long getNhs() {
        return nhsNumber;
    }

    /**
     * method to get the Client's Tax Identification number.
     * @return Client's Tax Identification number.
     */
    public long getTaxNumber() {
        return taxNumber;
    }

    /**
     * method to get the Client's birthdate.
     * @return Client's birthdate.
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * method to get the Client's role.
     * @return Client's role.
     */
    public String getRole() {
        return role;
    }

    /**
     * method to get the Client's gender.
     * @return Client's gender.
     */
    public String getGender() {
        return gender;
    }

    /**
     * method to get the Client's email.
     * @return Client's email.
     */
    public Email getEmail() {return email; }

    public String setName(String name) {
        validateName(name);
        return this.name = name;
    }

    /**
     * method to set a new Client's citizen Number.
     * @param citizenNumber new citizen Number.
     * @return New client's Citizen number.
     */
    public String setCitizen(String citizenNumber) {
        validateCitizenNumber((citizenNumber));
        return this.citizenNumber = citizenNumber; }

    /**
     * method to set a new Client's phone number.
     * @param phoneNumber new Client phone number.
     * @return new Client phone number.
     */
    public long setPhoneNumber(Long phoneNumber) {
        validatePhoneNumber(String.valueOf(phoneNumber));
        return this.phoneNumber = phoneNumber; }

    /**
     * method to set a new Client's NHS number.
     * @param nhsNumber new NHS Number.
     * @return New client's NHS number.
     */
    public long setNhs(Long nhsNumber) {
        validateNHSNumber(String.valueOf(nhsNumber));
        return this.nhsNumber = nhsNumber; }

    /**
     * method to set a new Client's Tax Number.
     * @param taxNumber new Tax Number.
     * @return New client's Tax Number.
     */
    public long setTaxNumber(Long taxNumber) {
        validateTIN(String.valueOf(taxNumber));
        return this.taxNumber = taxNumber;
    }

    /**
     * method to set a new Client's birthdate.
     * @param birthDate new birthdate.
     * @return New client's birthdate.
     */
    public Date setBirthDate(Date birthDate) {
        validateDate(birthDate);
        return this.birthDate = birthDate;
    }

    /**
     * method to set a new Client's role.
     * @param role new role.
     * @return New client's email.
     */
    public String setRole(String role) {
        return this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public String setAddress(String address) {
        validateAdress(address);
        return this.address = address;
    }

    /**
     * method to set a new Client's gender.
     * @param gender new gender.
     * @return New client's gender.
     */
    public String setGender(String gender) {
        validateGender(gender);
        return this.gender = gender;
    }

    public Email setEmail(String email) {
        Email email1 = new Email(email);
        return this.email = email1;
    }

    /**
     * Method to validate the Client's name.
     * @param name Client's name.
     */
    public void validateName(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("Name cannot be blank.");
        } else if (name.length() > Constants.VAL_NAME)
            throw new IllegalArgumentException("Introduce a valid name.");
    }

    /**
     * Method to validate the Client's Citizen number.
     * @param citizenNumber Client's Citizen number.
     */
    public void validateCitizenNumber(String citizenNumber) {
        if (citizenNumber.length() != Constants.VAL_CITIZEN) {
            throw new IllegalArgumentException("Insert a valid citizen number.");
        }
    }

    /**
     * Method to validate the Client's phone number.
     * @param phoneNumber Client's phone number.
     */
    public void validatePhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != Constants.VAL_PHONENUMBER) {
            throw new IllegalArgumentException("Insert a valid phone number.");
        }
    }

    /**
     * Method to validate the Client's NHS number.
     * @param nhsNumber Client's NHS number.
     */
    public void validateNHSNumber (String nhsNumber) {
        if (nhsNumber.length() != Constants.VAL_NHS)
            throw new IllegalArgumentException("Insert a valid NHS number.");
    }

    /**
     * Method to validate the Client's Tax number.
     * @param taxNumber Client's Tax number.
     */
    public void validateTIN (String taxNumber) {
        if (taxNumber.length() != Constants.VAL_NHS)
            throw new IllegalArgumentException("Insert a valid Tax number.");
    }

    /**
     * Method to validate the Client's role.
     * @param role Client's role.
     */
/*    public void validateRole (String role) {
        if (StringUtils.isBlank(role))
            throw new IllegalArgumentException("Role cannot be blank.");
    }*/

    /**
     * Method to validate the Client's gender.
     * @param gender Client's gender.
     */
    public void validateGender (String gender) {
        if (StringUtils.isBlank(gender))
            throw new IllegalArgumentException("Gender cannot be blank.");
    }

    /**
     * Method to validate the Client's birthdate.
     * @param birthDate Client's birthdate.
     */
    public void validateDate (Date birthDate) {
        long year = birthDate.getYear()+1900;
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        if (currentYear - year > Constants.VAL_BIRTH)
            throw new IllegalArgumentException("Insert a valid birthdate.");

    }
    public void validateAdress(String address) {
        if (StringUtils.isBlank(address) || address.length() > Constants.VAL_ADDRESS) {
            throw new IllegalArgumentException("Adress cannot be larger than 90 characters");
        }
    }
    @Override
    public String toString(){
        return "Name: " + name + "  Citizen Number: " + citizenNumber
                + "  Phone Number:" + phoneNumber + "  NHS Number: " + nhsNumber
                + "  Tax Identification Number: " + taxNumber + "  Birth Date: " + birthDate +
                "  Email: " + email
                +"  Address: "+ address;
    }
}