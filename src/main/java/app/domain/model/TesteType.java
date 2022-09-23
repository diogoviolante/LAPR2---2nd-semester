package app.domain.model;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TesteType implements Serializable {


    private  String collectingMethods;
    private  String code;
    private  String descriptionTest;
    private String name;
    private List<ParameterCategory> parameterCategoryList ;
    private List <Parameter> parameterList;
    /**
     * Constroy an instance  of TestType receiving  name, descriptionTest , code e collectingMethods
     *  @param name the name of the test
     * @param  descriptionTest the discrption of the test
     * @param  collectingMethods collecting method
     * @param  code the code of the test
     * @param parameterCategoryList
     */

    public TesteType(String name, String descriptionTest , String collectingMethods, String code, List<ParameterCategory> parameterCategoryList) {
        validateCode(code);
        validateCollectingMethods(collectingMethods);
        validateDescriptionOfTheTest(descriptionTest);
        validateName(name);
        this.name=name;
        this.descriptionTest=descriptionTest;
        this.code=code;
        this.collectingMethods=collectingMethods;
        this.parameterCategoryList=parameterCategoryList;
        this.parameterList=new ArrayList<>();

    }

    /**

     @return collecting method
     */
    public String getCollectingMethods() {
        return collectingMethods;
    }
    /**
     @return code
     */
    public String getCode() {
        return code;
    }


    public List<ParameterCategory> getParameterCategoryList(){
        return parameterCategoryList;
    }


    /**

     @return test description
     */
    public String getDescriptionTest() {
        return descriptionTest;
    }
    /**

     @return test name
     */
    public  String getName() {
        return name;
    }




    /**
     validate collecting method, if the validation is successful change the collecting method
     @param collectingMethods new collecting method
     */

    public final void validateCollectingMethods(String collectingMethods) {
        if (StringUtils.isBlank(collectingMethods) || collectingMethods.trim().isEmpty() || collectingMethods.trim().length() > 20) {
            throw new IllegalArgumentException("Collecting Methods, please insert a name with less than 20 characters");
        }
    }
    /**
     validate code, if the validation is successful change the code
     @param code new code
     */
    public final void validateCode(String code) {
        if (code.length()>5) {
            throw new IllegalArgumentException("Invalid code, please use a code with 5 numbers");

        }
    }
    /**
     validate descriptionTest, if the validation is successful change the description of the test
     @param descriptionTest new description test
     */
    public final void validateDescriptionOfTheTest(String descriptionTest){
        if(StringUtils.isBlank(descriptionTest) || descriptionTest.trim().isEmpty() || descriptionTest.trim().length() > 15) {
            throw new IllegalArgumentException("Invalid description, please use a description with  15 characters or less");
        }
    }

    /**
     validate name, if the validation is successful change the name
     @param name new name
     */
    public final void validateName(String name){
        if(StringUtils.isBlank(name)|| name.trim().isEmpty()|| name.trim().length()>10){
            throw new IllegalArgumentException("Invalid name, please use a name with 10 characters or less");
        }
    }

    /**
     method that decides how will the test information bew showed
     */
   // public String String(){
     //   return ( name + "name-" +descriptionTest +"description of the test-"+ collectingMethods+"Collecting methods-" + code +"Test code-");
    //}
    @Override
    public String toString() {
        return ( "name-" + name+"  " + "description of the test-" + descriptionTest+"  " + "Collecting methods-" + collectingMethods+"  " + "Test code-"+code+"  "+"Categories" +parameterCategoryList);
    }
        /*public boolean associateNewCategory(ParameterCategory category){
        for (ParameterCategory category1 : parameterCategoryList){
            if (category1.getCode().equalsIgnoreCase(category.getCode())){
                return false;
            }
        }
        parameterCategoryList.add(category);
        return true;
    }

         */
    public boolean associateNewParameter(Parameter parameter){
        for(Parameter parameter1 : parameterList){
            if(parameter1.getParameterCode()==parameter.getParameterCode()){
                return false;
            }
        }
    parameterList.add(parameter);
    return true;
    }


   // @Override
    //public boolean equals(Object o) {
      //  if (this == o) return true;
       // if (o == null || getClass() != o.getClass()) return false;
        //TesteType newTest = (TesteType) o;
        //return Objects.equals(name, TesteType.name) && Objects.equals(descriptionTest, TesteType.descriptionTest) && Objects.equals(collectingMethods, TesteType.collectingMethods) && Objects.equals(code,TesteType.code);
    //}

   //@Override
    //public int hashCode() {
      //  return Objects.hash(name, descriptionTest, collectingMethods,code);
    //}


}
