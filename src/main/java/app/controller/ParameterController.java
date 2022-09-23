package app.controller;

import app.domain.Store.ParameterStore;
import app.domain.model.Company;
import app.domain.model.Parameter;
import app.domain.model.ParameterCategory;
import app.domain.model.TesteType;

import java.util.List;

public class ParameterController {
    private Company company;
    private Parameter parameter;
    private final ParameterStore store ;

    public ParameterController() {
        this(App.getInstance().getCompany());
    }

    public ParameterController(Company company) {
        this.company=company;
        this.parameter=null;

        store = new ParameterStore();
    }

    public List<ParameterCategory> getControllerCategoryList() {
      return   this.company.getParameterCategoryList();
    }

    public boolean createParameter(String parameterCode,String shortName, String description, String category) {
       this.parameter= this.store.createParameter(parameterCode, shortName, description, category);

    return this.store.validateParameter(parameter);
    }

    public boolean saveParameter() {
        return this.store.saveParameter(parameter);

    }

    public List<Parameter> getParamterList() {
        return store.getParamterList();
    }

}
