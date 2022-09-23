package app.domain.Store;

import app.domain.model.AllDates;
import app.domain.model.Client;
import app.domain.model.Diagnosis;
import app.domain.model.TesteType;
import auth.domain.model.Email;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class DiagnosisStoreTest {

    DiagnosisStore diagnosisStore = new DiagnosisStore();
    Date date = new Date();
    String report = "ureueue";
    String code = "000000000001";


    TesteType type = new TesteType("test", "testof", "collecting", "12fg5", new ArrayList<>());
    Client cliente = new Client("diogo", "1234567891234567", 12345678912L, 1234567891L, 1234567891, new Date("2002/3/30"), "Client", new Email("ds@gmail.com"),"yauuuu");
    app.domain.model.Test teste = new app.domain.model.Test(cliente, "000000000001", "123456789123", type, new ArrayList<>(), "12345", new Date());
    Diagnosis diagnosis = new Diagnosis(report, date, code);




    @Test
    public void getDateList() { List<AllDates> result = diagnosisStore.getDateList(); }

    @Test
    public void createDiagnosis() { diagnosisStore.createDiagnosis( report, date, code ); }

    @Test
    public void validateDiagnosis() { diagnosisStore.validateDiagnosis(diagnosis); }

    @Test
    public void saveDiagnosis() { diagnosisStore.saveDiagnosis(diagnosis, report ); }

    @Test
    public void getDiagnosisList() { List<Diagnosis> result = diagnosisStore.getDiagnosisList(); }

    @Test
    public void getLongDate() { Long result = diagnosisStore.getLongDate(); }



}