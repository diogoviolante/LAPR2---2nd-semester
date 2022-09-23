package app.domain.model;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Parameter implements Serializable {
    /**
     * Code of the parameter.
     */
    private String parameterCode;
    /**
     * Name of the parameter.
     */
    private String shortName;
    /**
     * Description of the parameter.
     */
    private String description;
    /**
     * Category of the parameter.
     */
    private String category;
private List<Parameter> parameterList;
    /**
     * Paramter Constructor.
     * @param parameterCode parameter code
     * @param shortName
     * @param description
     * @param category
     */
    public Parameter(String parameterCode,String shortName, String description, String category){
        validateDescription(description);
        validateParameterCode(parameterCode);
        validateShortName(shortName);
        validateCategory(category);
    }

    public String getParameterCode() {
        return parameterCode;
    }

    public String getShortName() {
        return shortName;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }


    /**
     * Method that validates the cod of the parameter.
     * @param parameterCode code of the parameter.
     */
    public final void validateParameterCode(String parameterCode){
        if(parameterCode.length() != 5){
            throw new IllegalArgumentException("Invalid code, please insert a code with 5 numbers");
        }
        this.parameterCode=parameterCode;
    }
    /**
     * Method that validates the name of the parameter.
     * @param shortName name of the parameter.
     */
    public final void validateShortName(String shortName){
        if(StringUtils.isBlank(shortName)||shortName.trim().isEmpty()||shortName.trim().length()>8){
            throw new IllegalArgumentException(("Invalid short name, please insert a short name with 8 characters or less"));
        }
        this.shortName=shortName;
    }

    /**
     * Method that validates the name of the parameter.
     * @param description description of the parameter.
     */
    public final void validateDescription( String description){
        if(StringUtils.isBlank(description)|| description.trim().isEmpty()||description.length()>20){
            throw new IllegalArgumentException("Invalid description, please insert a description with 20 characters or less");
        }

        this.description=description;
    }

    /**
     * Method that validates the category of the parameter.
     * @param category category of the parameter.
     */
    public final void validateCategory(String category) {
        if (StringUtils.isBlank(category) || category.trim().isEmpty() || category.trim().length() > 8 || category.trim().length() < 4 ) {
            throw new IllegalArgumentException("Invalid category!");
        }
        this.category = category;
    }

    /**
     * Method that turns the parameter created into a String.
     * @return parameter in String.
     */
    @Override
    public String toString(){
        return String.format("%s-shortname, %s -code, %s -description, %s -category", shortName,parameterCode,description, category);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parameter parameter = (Parameter) o;
        return Objects.equals(parameterCode, parameter.parameterCode) && Objects.equals(shortName, parameter.shortName) && Objects.equals(description, parameter.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parameterCode, shortName, description);
    }


}