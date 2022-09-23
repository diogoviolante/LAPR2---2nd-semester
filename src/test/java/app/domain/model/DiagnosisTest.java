package app.domain.model;

import app.domain.shared.ListofTests;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class DiagnosisTest {

Diagnosis Diagnosis2= new Diagnosis("bom teste",new Date(), "0000000001");
    @Test
    public void validateReport() {

Diagnosis newDiagnosis = new Diagnosis("o teste foi efetuado corretamente",new Date(), "0000000001");
   String expectresult="o teste foi efetuado corretamente";
String result=newDiagnosis.getReport();
        assertEquals(expectresult,result);
    }


    @Test
    public void getReport() {
    String report= "bom teste";
    String result=Diagnosis2.getReport();
    assertEquals(report,result);
    }
}