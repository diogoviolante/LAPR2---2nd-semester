package app.domain.model;


import app.domain.shared.Constants;
import auth.domain.model.Email;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

public class Employee implements Serializable {



    /**
     * O papel do Employee.
     */
    private String role;

    /**
     * A id do Employee.
     */
    private String employeeID;

    /**
     * O nome do Employee.
     */
    private String name;

    /**
     * A morada do Employee.
     */
    private String address;

    /**
     * O email do Employee.
     */
    private Email email;

    /**
     * O número de telefone do Employee.
     */
    private String phoneNumber;

    /**
     * O SOC do Employee.
     */
    private long soc;

    /**
     * O index number do Specialist Doctor.
     */
    private long indexNumber;


    /**
     * Constrói uma instância de Employee recebendo o papel, id, nome, morada, email, número de telefone e soc.
     * @param role o papel do Employee
     * @param employeeID a id do Employee
     * @param name o nome do Employee
     * @param address a morada do Employee
     * @param email o email do Employee
     * @param phoneNumber o número de telefone do Employee
     * @param soc o SOC do Employee
     */
    public Employee(String role, String employeeID, String name, String address, Email email, String phoneNumber, long soc) {
        validateRole(role);
        this.role = role;

        validateName(name);
        this.name = name;

        this.employeeID = employeeID;


        validateAddress(address);
        this.address = address;

        validatePhoneNumber(phoneNumber);
        this.phoneNumber = phoneNumber;

        this.email = email;

        validateSoc(soc);
        this.soc = soc;
    }


    /**
     * Constrói uma instância de Employee recebendo o papel, id, nome, morada, email, número de telefone, soc e index number.
     * @param role o papel do Employee
     * @param employeeID a id do Employee
     * @param name o nome do Employee
     * @param address a morada do Employee
     * @param email o email do Employee
     * @param phoneNumber o número de telefone do Employee
     * @param soc o SOC do Employee
     * @param indexNumber o index number do Specialist Doctor
     */
    public Employee(String role, String employeeID, String name, String address, Email email, String phoneNumber, long soc, long indexNumber) {
        validateRole(role);
        this.role = role;

        validateName(name);
        this.name = name;


        this.employeeID = employeeID;


        validateAddress(address);
        this.address = address;

        validatePhoneNumber(phoneNumber);
        this.phoneNumber = phoneNumber;

        this.email = email;

        validateSoc(soc);
        this.soc = soc;

        validateIndexNumber(indexNumber);
        this.indexNumber = indexNumber;
    }


    /**
     * Devolve o papel do Employee.
     *
     * @return papel do Employee
     */
    public String getRole() { return role; }


    /**
     * Devolve o ID do Employee.
     *
     * @return ID do Employee
     * @param name o novo do Employee
     */
    public String getEmployeeID(String name) { return employeeID; }


    /**
     * Devolve o nome do Employee.
     *
     * @return nome do Employee
     */
    public String getName() { return name; }


    /**
     * Devolve a morada do Employee.
     *
     * @return morada do Employee
     */
    public String getAddress() { return address; }


    /**
     * Devolve o email do Employee.
     *
     * @return email do Employee
     */
    public Email getEmail() { return email; }



    /**
     * Devolve o numero de telefone do Employee.
     *
     * @return numero de telefone do Employee
     */
    public String getPhoneNumber() { return phoneNumber; }


    /**
     * Devolve o soc do Employee.
     *
     * @return soc do Employee
     */
    public long getSoc() { return soc; }


    /**
     * Devolve o index number do Employee.
     *
     * @return index number do Employee
     */
    public long getIndexNumber() { return indexNumber; }



    /**
     * Valida o papel do Employee.
     */
    public void validateRole(String role){
        if (role.length() > Constants.VAL_ROLE)
            throw new IllegalArgumentException("Role cannot exceed the limit");
        if (StringUtils.isBlank(role))
            throw new IllegalArgumentException("Role cannot be blank.");
    }

    /**
     * Valida o nome do Employee.
     */
    public void validateName(String name){
        if (name.length() > Constants.VAL_NAME)
            throw new IllegalArgumentException("Employee must have less than 36 characters");
        if (StringUtils.isBlank(name))
            throw new IllegalArgumentException("Employee must have a name");
    }

    /**
     * Valida a morada do Employee.
     */
    public void validateAddress(String address) {
        if (address.length() > Constants.VAL_ADDRESS)
            throw new IllegalArgumentException("Employee's address must have less than 91 characters");
        if (StringUtils.isBlank(address))
            throw new IllegalArgumentException("Employee's address must have an address");
    }

    /**
     * Valida o numero de telefone do Employee.
     */
    public void validatePhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != Constants.VAL_PHONENUMBER) {
            throw new IllegalArgumentException("Employee's phone number must have 11 digits");
        } else if (StringUtils.isBlank(phoneNumber)) {
            throw new IllegalArgumentException("Employee must have a phone number");
        }
    }

    /**
     * Valida o soc do Employee.
     */
    public void validateSoc (long soc) {
        if (soc < Constants.VAL_SOC_MIN || soc > Constants.VAL_SOC_MAX)
            throw new IllegalArgumentException("Employee's SOC must have 4 digits");
    }

    /**
     * Valida o index number do Employee.
     */
    public void validateIndexNumber (long indexNumber) {
        if (indexNumber < Constants.VAL_INDEXNUMBER_MIN || indexNumber > Constants.VAL_INDEXNUMBER_MAX)
            throw new IllegalArgumentException("Employee's index number must have 6 digits");
    }


    /**
     * Devolve os atributos do Employee.
     */
    @Override
    public String toString() {
        return ("role- " + role + "employee Id- " + employeeID + "name- " + name + "address- " + address + "email- " + email + "phone number- " + phoneNumber + "SOC- " + soc);
    }


}