package app.domain.Store;

import app.domain.model.Parameter;
import app.domain.model.TesteType;
import app.domain.shared.ListOfParameters;

import java.util.ArrayList;
import java.util.List;

public class ParameterStore implements ListOfParameters {

    /**
     * Attribute from Parameter Class.
     */
    private Parameter parameter;

    /**
     * ArrayList to save the parameters created
     */
   // private List<Parameter> parameterList= new ArrayList<>();
public ParameterStore(){
    //this.parameterList=new ArrayList<>();
}
    /**
     * Creates a new parameter with a chosen category.
     * @param parameterCode code of the parameter.
     * @param shortName short name to identify the parameter.
     * @param description description to understand the parameter
     * @param category parameter category
     */
    public Parameter createParameter(String parameterCode,String shortName, String description, String category) {
       return new Parameter(parameterCode,shortName,description,category);
    }

    /**
     * Method to validate the parameter created.
     * @param parameter paraeter created in createParameter.
     * @return
     */
    public boolean validateParameter(Parameter parameter) {
        if (parameter == null) {
           return false;
        }
      return !parameterList.contains(parameter);
    }

    /**
     * Method to save the parameter created.
     * @param parameter parameter created in createParameter.
     */
    public boolean saveParameter(Parameter parameter) {
        if(!validateParameter(parameter))
    return false;
        return parameterList.add(parameter);
    }

    public List<Parameter> getParamterList () {

        return parameterList ;
    }
    public Parameter getParameterByCode(String paramterCode){
        for(Parameter parameter : parameterList) {
            if(parameter.getParameterCode().equals(paramterCode)){
                return parameter;
            }
        }
        return null;
    }

}