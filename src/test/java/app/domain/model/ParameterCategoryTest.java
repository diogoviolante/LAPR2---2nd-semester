package app.domain.model;


import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class ParameterCategoryTest {

    String param = "12345";
    String shortname = "arroz";
    String descrip = "okokoko";
    String categ = "cacaca";
    app.domain.model.ParameterCategory parameterCategory = new app.domain.model.ParameterCategory("12345", "covid");
    Parameter parameter = new Parameter("12345", "arroz", "okokoko", "cacaca");
    List<Parameter> parameterList = new ArrayList<>();


    @Test
    public void getCode() {
        String result = parameterCategory.getCode();
        String expresult = "12345";
        assertEquals(expresult, result);
    }
    @Test
    public void setCode() {
        parameterCategory.setCode("arroz");
        String result = parameterCategory.getCode();
        String expresult = "arroz";
        assertEquals(expresult, result);
    }



    @Test
    public void getName() {
        String result = parameterCategory.getName();
        String expresult = "covid";
        assertEquals(expresult, result);
    }
    @Test
    public void setName() {
        parameterCategory.setName("arroz");
        String result = parameterCategory.getName();
        String expresult = "arroz";
        assertEquals(expresult, result);
    }


    @Test
    public void getParameterList() { List<Parameter> result =  parameterCategory.getParameterList(); }

    @Test
    public void addParameter() { parameterCategory.addParameter(parameter); }

    @Test
    public void specifyParameter() { parameterCategory.specifyParameter(this.param, this.shortname, this.descrip, this.categ); }




    @Test (expected = IllegalArgumentException.class)
    public void checkCodeRules() {
        app.domain.model.ParameterCategory pc= new app.domain.model.ParameterCategory("1234","yau");
        pc.checkCodeRules(pc.getCode());
    }

    @Test
    public void checkCodeRules2(){
        app.domain.model.ParameterCategory pc= new app.domain.model.ParameterCategory("12345","yaute");
        pc.checkCodeRules(pc.getCode());
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkNameRules() {
        app.domain.model.ParameterCategory pc= new app.domain.model.ParameterCategory("12345","yadsssssssssssssssssssssssssu");
        pc.checkNameRules(pc.getName());
    }

    @Test
    public void checkNameRules2(){
        app.domain.model.ParameterCategory pc= new ParameterCategory("12345","yaute");
        pc.checkNameRules(pc.getName());
    }


    @Test
    public void testToString() { String result = parameterCategory.toString(); }

    @Test
    public void testEquals() {
        boolean result = param.equals("12345");
        assertTrue(result);
    }
    @Test
    public void testEquals2() {
        boolean result = param.equals("00000");
        assertFalse(result);
    }
    @Test
    public void testEquals3() {
        boolean result = param.equals("") ;
        assertFalse(result);
    }

    @Test
    public void testHashCode() { Object result = parameterCategory.hashCode(); }

}

