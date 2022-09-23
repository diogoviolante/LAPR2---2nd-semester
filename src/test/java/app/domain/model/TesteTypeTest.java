

package app.domain.model;

import app.domain.model.TesteType;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TesteTypeTest {
    private List<ParameterCategory> cat = new ArrayList<>();
    private TesteType newTest= new TesteType("dadadada","bugabugabuga","bobo","14235", cat);

    @Test
    public void validateCollectingMethods() {
        newTest.validateCollectingMethods("dadadad");
    }
    @Test(expected = IllegalArgumentException.class)
    public void validateCollectingMethods2(){
        newTest.validateCollectingMethods("dododdodododododoododododododod");
    }
    @Test
    public void validateCode() {
        newTest.validateCode("14235");
    }
    @Test(expected = IllegalArgumentException.class)
    public void validateCode2(){
        newTest.validateCode("1234556788");
    }
    @Test
    public void validateDescriptionOfTheTest() {
        newTest.validateDescriptionOfTheTest("bugabugabug");
    }
    @Test(expected = IllegalArgumentException.class)
    public void validateDescriptionOfTheTest2(){
        newTest.validateDescriptionOfTheTest("buggggggggggggggggaaaaaaaaaaaaaaaaaaaaaaaaaaaaabug");
    }

    @Test
    public void validateName() {
        newTest.validateName("bobo");
    }
    @Test(expected = IllegalArgumentException.class)
    public void validateName2(){
        newTest.validateName("ndsanasdnsansdanansdnsad");
    }

    @Test
    public void validateCollectingMethodsAssert(){
     //   cat.add("wrw");
        TesteType newTest = new TesteType("covid","teste feito","zarabatana","12345", cat);
        String exepectresult="zarabatana";
        String result=newTest.getCollectingMethods();
        assertEquals(exepectresult,result);
    }
@Test
    public void validateDescriptionOfTheTestAssert(){
        //cat.add("wrw");
        TesteType newTest= new TesteType("covid","teste feito","zarabatana","12345", cat);
        String expectresult="teste feito";
        String result=newTest.getDescriptionTest();
        assertEquals(expectresult,result);
}
@Test
    public void validateNameAssert(){
  //  cat.add("wrw");
    TesteType newTest= new TesteType("covid","teste feito","zarabatana","12345", cat);
    String expectresult="covid";
    String result=newTest.getName();
    assertEquals(expectresult,result);
}
@Test
    public void validateCodeAssert(){
   // cat.add("wrw");
    TesteType newTest= new TesteType("covid","teste feito","zarabatana","12345", cat);
    String expectresult="12345";
   String result=newTest.getCode();
    assertEquals(expectresult,result);
}

}