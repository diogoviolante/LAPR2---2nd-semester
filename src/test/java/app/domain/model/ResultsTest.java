package app.domain.model;


import org.junit.Test;
import static org.junit.Assert.*;

public class ResultsTest {

   Results results = new Results("covid", "okokoko", "12345", "positive", 1.2);

    @Test
    public void getTestType() {
        String result = results.getTestType();
        String expresult = "covid";
        assertEquals(expresult, result);
    }
    @Test
    public void setTestType() {
        results.setTestType("arroz");
        String result = results.getTestType();
        String expresult = "arroz";
        assertEquals(expresult, result);
    }

    @Test
    public void getValue(){
        double result= results.getValue();
        double expresult = 1.2;
        assertEquals(expresult, result, 0.0001);
    }

    @Test
    public void setValue(){
        results.setValue(1.5);
        double result= results.getValue();
        double expresult = 1.5;
        assertEquals(expresult, result, 0.0001);
    }

    @Test
    public void getParameter() {
        String result = results.getParameter();
        String expresult = "okokoko";
        assertEquals(expresult, result);
    }
    @Test
    public void setParameter() {
        results.setParameter("arroz");
        String result = results.getParameter();
        String expresult = "arroz";
        assertEquals(expresult, result);
    }



    @Test
    public void isResult() {
        String result = results.isResult();
        String expresult = "positive";
        assertEquals(expresult, result);
    }
    @Test
    public void setResult() {
        results.setResult("arroz");
        String result = results.isResult();
        String expresult = "arroz";
        assertEquals(expresult, result);
    }



    @Test
    public void getCode() {
        String result = results.getCode();
        String expresult = "12345";
        assertEquals(expresult, result);
    }
    @Test
    public void setCode() {
        results.setCode("arroz");
        String result = results.getCode();
        String expresult = "arroz";
        assertEquals(expresult, result);
    }

    @Test
    public void testToString() { String result = results.toString(); }


}