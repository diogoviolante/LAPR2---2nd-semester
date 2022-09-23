package app.domain.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParameterTest {
    Parameter paramter1=new Parameter("12344","buga","bugaa","yaaau");
    @Test
    public void validateParameterCode() {
        Parameter newParamter= new Parameter("12345","buga","bugaa","yaaau");
        String expectresult= "12345";
        String result= newParamter.getParameterCode();
        assertEquals(expectresult,result);
    }

    @Test
    public void validateShortName() {
        Parameter newParamter= new Parameter("12345","buga","bugaa","yaaau");
        String expectresult="buga";
        String result=newParamter.getShortName();
        assertEquals(expectresult,result);
    }

    @Test
    public void validateDescription() {
        Parameter newParamter= new Parameter("12345","buga","bugaa","yaaau");
        String expectresult="bugaa";
        String result= newParamter.getDescription();
        assertEquals(expectresult,result);
    }
    @Test(expected = IllegalArgumentException.class)
    public void validateParamterCode2(){
        paramter1.validateParameterCode("12345678");
    }
    @Test(expected = IllegalArgumentException.class)
    public void validateDescription2(){
        paramter1.validateDescription("bugaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }
    @Test(expected = IllegalArgumentException.class)
    public void validateShortName2(){
        paramter1.validateShortName("bugiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
    }



}