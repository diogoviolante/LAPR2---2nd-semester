package app.controller;

import app.domain.Store.DiagnosisStore;
import app.domain.model.AllDates;
import app.domain.model.Company;
import app.domain.model.Diagnosis;

import java.util.Date;
import java.util.List;

public class DiagnosisController {

    private final Company company;
    private Diagnosis diagnosis;
    private final DiagnosisStore store = new DiagnosisStore() ;


public DiagnosisController(){
    this(App.getInstance().getCompany());
}

public DiagnosisController(Company company){
    this.company=company;
    this.diagnosis=null;
    }

  public boolean getDiagnosis(String report, Date date, String code){
        this.diagnosis=this.store.createDiagnosis(report,date, code);
        return this.store.validateDiagnosis(diagnosis);

  }
public boolean saveDiagnosis(String code){
    return this.store.saveDiagnosis(diagnosis, code);
}

public List<Diagnosis> getDiagnosisList(){
return store.getDiagnosisList();
}

public List<AllDates> getDateList(){
return store.getDateList();
}

}
