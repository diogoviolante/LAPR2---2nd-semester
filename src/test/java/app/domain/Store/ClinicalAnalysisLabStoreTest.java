package app.domain.Store;

import app.domain.model.ClinicalAnalysisLaboratory.ClinicalAnalysisLaboratory;
import app.domain.model.Company;
import app.domain.model.TesteType;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import app.dto.CreateAnalysisClinicalLabDTO;

import java.util.ArrayList;
import java.util.List;

public class ClinicalAnalysisLabStoreTest implements app.domain.shared.ClinicalAnalysisLaboratories {
     List<TesteType> newTesteContainer = new ArrayList<TesteType>();
     CreateAnalysisClinicalLabDTO dto = new CreateAnalysisClinicalLabDTO("12345", "nameclinic", "rua da vida", "12345678911", "1234567891", newTesteContainer);
     Company company = new Company("porto");
     ClinicalAnalysisLabStore store = new ClinicalAnalysisLabStore(company);
     ClinicalAnalysisLaboratory cal;


    @Test
    public void validateClinicalAnalysisLab() {
        boolean result = store.validateClinicalAnalysisLab(store.createClinicalAnalysisLab(dto));
        Assert.assertEquals(true, result);
    }

    @Test
    public void saveClinicalAnalysisLab() {
        boolean result = store.saveClinicalAnalysisLab(store.createClinicalAnalysisLab(dto));
        Assert.assertEquals(true, result);
    }
    @Test
        public void addClinicalAnalysislab () {
            boolean result = store.addClinicalAnalysisLab(store.createClinicalAnalysisLab(dto));
            Assert.assertEquals(true, result);
        }
    }