package app.domain.model.ClinicalAnalysisLaboratory;

import app.domain.model.TesteType;
import app.dto.CreateAnalysisClinicalLabDTO;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
public class ClinicalAnalysisLaboratoryTest {
    private List<TesteType> newTestContainer = new ArrayList<TesteType>();
    private CreateAnalysisClinicalLabDTO dto = new CreateAnalysisClinicalLabDTO("aaaaa", "acascas", "zxczczcz", "12345678911", "1234567890", newTestContainer);
    private ClinicalAnalysisLaboratory cal = new ClinicalAnalysisLaboratory(dto);

    @Test
    public void validateLaboratoryID() {
        cal.validateLaboratoryID(dto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateLaboratoryID2() {
        dto.setLaboratoryID("aaaaaaaaaaaaaaaaaaaaa");
        cal.validateLaboratoryID(dto);
    }

    @Test
    public void validateName() {
        cal.validateName(dto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateName2() {
        dto.setName("aaaaaaaaaaaaaaaaaaaaaaaa");
        cal.validateName(dto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateAddress() {
        dto.setAddress("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        cal.validateAddress(dto);
    }

    @Test
    public void validateAddress2() {
        cal.validateAddress(dto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void validatePhone_Number() {
        dto.setPhoneNumber("");
        cal.validatePhoneNumber(dto);
    }

    @Test
    public void validatePhoneNumber2() {
        cal.validatePhoneNumber(dto);
    }


    @Test(expected = IllegalArgumentException.class)
    public void validateTinNumber() {
        dto.setTinNumber("");
        cal.validateTinNumber(dto);
    }


    @Test
    public void validateTinNumber2() {
        cal.validateTinNumber(dto);
    }
}