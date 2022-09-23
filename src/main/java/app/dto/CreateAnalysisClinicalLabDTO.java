package app.dto;

import app.domain.model.TesteType;

import java.util.List;

public class CreateAnalysisClinicalLabDTO {
    private String laboratoryID;
    private String name;
    private String address;
    private String phoneNumber;
    private String tinNumber;
    private TesteType newTestContainer;

    /**
     * DTo were data is preserved
     * @param laboratoryID
     * @param name
     * @param address
     * @param phoneNumber
     * @param tinNumber
     * @param newTestContainer
     */
    public CreateAnalysisClinicalLabDTO(String laboratoryID, String name, String address, String phoneNumber, String tinNumber, List<TesteType> newTestContainer) {
        this.laboratoryID = laboratoryID;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.tinNumber = tinNumber;
        this.newTestContainer = null;
    }

    /**
     * getter of laboatory ID
     * @return
     */
    public String getLaboratoryID() {
        return laboratoryID;
    }

    /**
     * setter of laboratory ID
     * @param laboratoryID
     */
    public void setLaboratoryID(String laboratoryID) {
        this.laboratoryID = laboratoryID;
    }

    /**
     * getter of name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * setter of name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter of address
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     * setter of address
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * getter of Phone Number
     * @return
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * setter of Phone Number
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * getter of tinNumber
     * @return
     */
    public String getTinNumber() {
        return tinNumber;
    }

    /**
     * setter of tinNumber
     * @param tinNumber
     */
    public void setTinNumber(String tinNumber) {
        this.tinNumber = tinNumber;
    }

    /**
     * getter of the list with the tests
     * @return
     */
    public TesteType getNewTestContainer() {
        return newTestContainer;
    }

    /**
     * setter of the list with the tests
     * @param NewTestContainer
     */
    public void setNewTestContainer(TesteType NewTestContainer) {
        this.newTestContainer = NewTestContainer;
    }
}