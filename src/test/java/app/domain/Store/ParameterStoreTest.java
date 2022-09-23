package app.domain.Store;

import app.domain.model.Parameter;
import app.domain.shared.ListOfParameters;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ParameterStoreTest implements ListOfParameters {

    ParameterStore parameterStore = new ParameterStore();
    String paramCode = "12345";
    String category = "arroz";
    String description = "welelele";
    String shortName = "ud";
    Parameter parameter = new Parameter(paramCode, shortName, description, category);


    @Test
    public void createParameter() { parameterStore.createParameter(paramCode, shortName, description, category); }

    @Test
    public void validateParameter() { parameterStore.validateParameter(parameter); }

    @Test
    public void saveParameter() { parameterStore.saveParameter(parameter); }

    @Test
    public void getParamterList() { List<Parameter> result = parameterStore.getParamterList(); }

    @Test
    public void getParameterByCode() { parameterStore.getParameterByCode(paramCode); }


}