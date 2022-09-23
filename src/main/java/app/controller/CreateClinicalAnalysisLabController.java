package app.controller;

import app.domain.Store.ClinicalAnalysisLabStore;
import app.domain.model.ClinicalAnalysisLaboratory.ClinicalAnalysisLaboratory;
import app.domain.model.Company;
import app.dto.CreateAnalysisClinicalLabDTO;

public class CreateClinicalAnalysisLabController {

    private ClinicalAnalysisLabStore store;
    private Company company;
    private ClinicalAnalysisLaboratory cal;

    /**
     *
     */
    public CreateClinicalAnalysisLabController(){
        this(App.getInstance().getCompany());
    }

    /**
     *
     * @param company
     */
    public CreateClinicalAnalysisLabController(Company company){
        this.company=company;
        this.cal=null;
    }

    /**
     * Creates Clinical Analysis Laboratory with the attributes reserved on DTO
     * @param dto
     */
    public void createClinicalAnalysisLab(CreateAnalysisClinicalLabDTO dto){
        store= company.getStore();
        cal = store.createClinicalAnalysisLab(dto);
    }

    /**
     * Method to save CLinical Analysis Lab
     */
    public void saveClinicalAnalysisLab(){
        store.saveClinicalAnalysisLab(cal);
    }
}
