package app.controller;
import app.domain.Store.ParameterStore;
import app.domain.model.Company;

import app.domain.model.Parameter;
import app.domain.model.ParameterCategory;
import app.domain.model.TesteType;

import java.util.ArrayList;
import java.util.List;

public class NewTestController {
    private final ParameterStore store= new ParameterStore();
    private TesteType newTest;
    private Company company;


    //List<ParameterCategory> listacategorias = new ArrayList<ParameterCategory>();

    public NewTestController() {
        this(App.getInstance().getCompany());
    }

    /**
     * calls company method to add a new test
     *
     * @return test if sucessfuly validated
     */

    public NewTestController(Company company) {
        this.company = company;
        this.newTest = null;
    }

    public TesteType addNewTest(String name, String descriptionTest, String collectingMethods, String code, List<ParameterCategory> parameterCategoryList) {
        return this.company.addNewTest(name, descriptionTest,collectingMethods, code, parameterCategoryList);
    }

    public boolean saveNewTest(TesteType newTest) {
        return this.company.saveNewTest(newTest);
    }




    /**
     * calls company method to save a test
     */


    public List<TesteType> getNewTestContainer() {
        return company.getNewTestContainer();
    }
    public List<ParameterCategory> getCategoryList(){
        return company.getParameterCategoryList();
    }

    /*public boolean associateCategory(ParameterCategory category){
        return TestType.associateNewCategory(category);
    }

     */

    public ParameterCategory getCategoryByCode(String name){
        return company.getParameterCategoryByName(name);
    }
public boolean associateParameter(Parameter parameter){
        return newTest.associateNewParameter(parameter);

}
public Parameter getParameterByCode(String paramtercode){
        return store.getParameterByCode(paramtercode);
}

public List<Parameter> getParamterList() {
    return store.getParamterList();
}
}






