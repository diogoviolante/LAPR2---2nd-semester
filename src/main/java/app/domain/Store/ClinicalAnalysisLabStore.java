package app.domain.Store;

import app.domain.model.ClinicalAnalysisLaboratory.ClinicalAnalysisLaboratory;
import app.domain.model.Company;
import app.dto.CreateAnalysisClinicalLabDTO;
import auth.AuthFacade;

import java.util.List;

public class ClinicalAnalysisLabStore implements app.domain.shared.ClinicalAnalysisLaboratories {
        private CreateAnalysisClinicalLabDTO dto;
        private ClinicalAnalysisLaboratory Cal;
        private Company company;


        public ClinicalAnalysisLaboratory createClinicalAnalysisLab(CreateAnalysisClinicalLabDTO dto) {
            return Cal = new ClinicalAnalysisLaboratory(dto);
        }

        public ClinicalAnalysisLabStore(Company company) {
            this.company=company;
        }

        public boolean validateClinicalAnalysisLab(ClinicalAnalysisLaboratory Cal) {
            if (Cal == null)
                return false;
            return true;
        }

        public boolean addClinicalAnalysisLab(ClinicalAnalysisLaboratory Cal) {
            return clinicalAnalysisLaboratories.add(Cal);
        }

        public boolean saveClinicalAnalysisLab(ClinicalAnalysisLaboratory Cal) {
            if (!(validateClinicalAnalysisLab(Cal)) || !(addClinicalAnalysisLab(Cal)))
                return false;
            return true;


        }

        public List<ClinicalAnalysisLaboratory> getLabs() {
            return clinicalAnalysisLaboratories;
        }
    }
