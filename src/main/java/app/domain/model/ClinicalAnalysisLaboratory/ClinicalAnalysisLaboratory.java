package app.domain.model.ClinicalAnalysisLaboratory;

import app.domain.model.TesteType;
import app.dto.CreateAnalysisClinicalLabDTO;

public class ClinicalAnalysisLaboratory {
    private String laboratoryID;
    private String name;
    private String address;
    private String phoneNumber;
    private String tinNumber;
    private TesteType newTestContainer;
    private CreateAnalysisClinicalLabDTO dto;
    private int laboratoryIdDigits=5;
    private int nameDigitsSup=20;
    private int nameDigitsMin=1;
    private int addressSup=30;
    private int addressMin=1;
    private int phoneNumberLim=11;
    private int tinNumberLim=10;
    /**
     * Creates a Clinical Analysis Laboratory
     * @param dto
     */
    public ClinicalAnalysisLaboratory(CreateAnalysisClinicalLabDTO dto) {
        this.laboratoryID = dto.getLaboratoryID();
        this.name = new String(dto.getName());
        this.address = new String(dto.getAddress());
        this.phoneNumber = dto.getPhoneNumber();
        this.tinNumber = dto.getTinNumber();
    }

    /**
     * Laboratory ID must have 5 alhpanumeric characters
     * @param dto
     */
    public void validateLaboratoryID(CreateAnalysisClinicalLabDTO dto){
        if (dto.getLaboratoryID().length() !=laboratoryIdDigits)
            throw new IllegalArgumentException("Laboratory ID must have 5 alphanumeric characters.");
    }

    /**
     * Laboratory Name must have less than 20 characters
     * @param dto
     */
    public void validateName(CreateAnalysisClinicalLabDTO dto){
        if (dto.getName().length()>nameDigitsSup)
            throw new IllegalArgumentException("Laboratory must have less than 20 characters");
        if (dto.getName().length()<nameDigitsMin)
            throw new IllegalArgumentException("Laboratory must have a name");
    }

    /**
     * Laboratory Address must have less than 30 characters
     * @param dto
     */
    public void validateAddress(CreateAnalysisClinicalLabDTO dto) {
        if (dto.getAddress().length() > addressSup)
            throw new IllegalArgumentException("Laboratory must have less than 30 characters");
        if (dto.getAddress().length() < addressMin)
                throw new IllegalArgumentException("Laboratory must have an address");

    }

    /**
     * Laboratory Phone Number must have 11 digits!
     * @param dto
     */

    public void validatePhoneNumber(CreateAnalysisClinicalLabDTO dto){
        if (dto.getPhoneNumber().length() !=phoneNumberLim)
            throw new IllegalArgumentException("Laboratory phone number must have exactly 11 digits!");
    }

    /**
     * TIN Number must have 10 digits!
     * @param dto
     */
    public void validateTinNumber(CreateAnalysisClinicalLabDTO dto){
        if(dto.getTinNumber().length() !=tinNumberLim)
            throw new IllegalArgumentException("Laboratory Tin Number must have exactly 10 digits");
    }
}