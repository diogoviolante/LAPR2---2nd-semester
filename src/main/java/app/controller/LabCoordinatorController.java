
package app.controller;

import app.domain.Store.AvailableTestStore;
import app.domain.model.Company;
import app.domain.model.Test;
import app.domain.model.ValidationCoordinator;
import app.dto.validationCoordinatorDto;

import java.util.ArrayList;
import java.util.List;


public class LabCoordinatorController {

    private Company company;
    private AvailableTestStore store;
    private List<ValidationCoordinator> checkList;

    public LabCoordinatorController(){
        this.company = App.getInstance().getCompany();
        this.store = this.company.getAvailableTestStore();
    }
    public LabCoordinatorController(Company company){
        this.company=company;
        this.store=new AvailableTestStore();
        this.checkList=new ArrayList<>();
    }
    public List<Test> getTestList(){
        return company.getTestList();
    }
    public List<ValidationCoordinator> createValidationCoordinator(List<validationCoordinatorDto> valDtoList){
        for (validationCoordinatorDto dto : valDtoList){
            ValidationCoordinator val=this.store.createValidationCoordinator(dto);
            this.store.validateValidationCoordinator(val);
            checkList.add(val);
        }
        return checkList;
    }

    public boolean AddValidationCoordinator(Test test){
        return this.store.addValidationCoordinator(test);
    }
}