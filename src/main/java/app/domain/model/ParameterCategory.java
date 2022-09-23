package app.domain.model;

import org.apache.commons.lang3.StringUtils;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ParameterCategory implements Serializable {
    private String name;
    private String code;
    private List<Parameter> parameterList;
    //private List<ParameterCategory> parameterCategoryList;
    /**
     * this method call the methods and if it succeeds, the atributes change value
     * @param code of the parameter
     * @param name of the parameter
     */
    public ParameterCategory(String code, String name) {
        checkCodeRules(code);
        checkNameRules(name);
        this.code = code;
        this.name = name;
   this.parameterList= new ArrayList<>();
    }



    /**
     * gets the code
     * @return the code of the parameter
     */
    public String getCode() {
        return code;
    }

    /**
     * setts the code with a new value
     * @param code to choose a different code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * gets the name
     * @return the name of the parameter
     */
    public String getName() {
        return name;
    }

    /**
     * setts the name
     * @param name to choose a different name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * validates code
     * @param code to validate
     */
    public void checkCodeRules(String code) {
        if (StringUtils.isBlank(code))
            throw new IllegalArgumentException("Code cannot be blank");
        if ((code.length() != 5))
            throw new IllegalArgumentException("Code must have 4 to 8 chars");
    }

    /**
     * validates name
     * @param name to validate
     */
    public void checkNameRules(String name) {
        if (StringUtils.isBlank(name))
            throw new IllegalArgumentException("Name cannot be blank");
        if (name.length() > 15)
            throw new IllegalArgumentException("Name must to be shorter than 10 characters");
        if (name.length() < 4)
            throw new IllegalArgumentException("Name must have more than 4 characters");
    }

    public List<Parameter> getParameterList() {
        return parameterList;
    }

    public boolean addParameter(Parameter parameter){
        for (Parameter parameter1 : parameterList) {
            if (parameter1.getParameterCode().equals(parameter.getParameterCode())){
                return false;
            }
        }
        parameterList.add(parameter);
        return true;
    }
    public Parameter specifyParameter(String parameterCode, String shortName, String description,String category){
        return new Parameter(parameterCode, shortName, description,category);
    }

    @Override
    public String toString(){
        return ( "name"+" "+name+"  "+"code"+" "+code);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParameterCategory that = (ParameterCategory) o;
        return Objects.equals(code, that.code) && Objects.equals(name, that.name)
                ;
    }



    @Override
    public int hashCode() {
        return Objects.hash(code, name);
    }


}
