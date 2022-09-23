package app.controller;

import app.domain.model.Company;
import app.domain.model.ParameterCategory;

import java.util.List;

public class ParameterCategoryController {
    private Company company;
    private ParameterCategory pc;


    public ParameterCategoryController() {
        this(App.getInstance().getCompany());
    }

    public ParameterCategoryController(Company company){
        this.company=company;
        this.pc = null;
    }

    public boolean createParameterCategory(String code, String name){
        this.pc = company.createParameterCategory(code, name);
        return this.company.validateParameterCategory(company.createParameterCategory(code, name));
    }

    public boolean saveParameterCategory(){
        return this.company.saveParameterCategory(pc);
    }


    public List<ParameterCategory> getParameterCategoryList() {
        return this.company.getParameterCategoryList();
    }

public ParameterCategory getParameterCategoryByName(String name){
        return company.getParameterCategoryByName(name);
}

}


