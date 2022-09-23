package app.domain.Store;

import app.domain.model.AllDates;
import app.domain.model.Diagnosis;
import app.domain.shared.ListDates;
import app.domain.shared.ListOfDiagnosis;

import java.util.Date;
import java.util.List;


public class DiagnosisStore implements ListDates, ListOfDiagnosis {

    /**
     * intialize the TestStore
     */
    private final TestStore store= new TestStore();

    /**
     * New instance of Date
     */
    private Date date = new Date();
    /**
     * Create a long
     */
    private Long longDate;


    /**
     * return the datelist
     */
    public List<AllDates> getDateList(){
        return datesList;
    }

    public DiagnosisStore() {

        List<AllDates> dates=store.getDates();
    }

    /**
     * return the method that create the diagnosis
     */
    public Diagnosis createDiagnosis(String report, Date date, String code) {
        return new Diagnosis(report,date, code);
    }

    /**
     * verifies if the diagnosis isnt null and if that one already exists
     */
    public boolean validateDiagnosis(Diagnosis diagnosis) {
        if (diagnosis == null) {
            return false;
        }

        return !diagnosisList.contains(diagnosis);
    }
    /**
     * save the diagnosis on the list
     */
public boolean saveDiagnosis(Diagnosis diagnosis, String code){
        if(!validateDiagnosis(diagnosis))
            return false;

    this.store.getDates().add(new AllDates(code, new Date(), "Diagnosis"));


    return this.diagnosisList.add(diagnosis);

    }

    /**
     * return diagnosislist
     */
    public List<Diagnosis> getDiagnosisList() {
        return diagnosisList;
    }
    /**
     * return longDate
     */
    public Long getLongDate() {
        return longDate;
    }
}