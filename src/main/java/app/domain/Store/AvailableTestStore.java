package app.domain.Store;

import app.domain.Store.TestStore;
import app.domain.model.Company;
import app.domain.model.Test;
import app.domain.model.ValidationCoordinator;
import app.domain.shared.ListofTests;
import app.domain.shared.PastTests;
import app.dto.validationCoordinatorDto;

import java.util.Date;
import java.util.List;

public class AvailableTestStore implements PastTests {
    private Company company;
    private List<ValidationCoordinator> ValidationCoordinatorList;
    private ValidationCoordinator LabVal;
    private Test test;

    /**
     *
     * creates a validation Coordinator
     */
    public ValidationCoordinator createValidationCoordinator(validationCoordinatorDto dto){
        TestStore test = dto.getTest();
        return new ValidationCoordinator(test);
    }
    /**
     *
     * validates the validation coordinator
     * return false if null
     */
    public boolean validateValidationCoordinator(ValidationCoordinator val) {
        if (val == null) {
            return false;
        }
        for (ValidationCoordinator LabVal : ValidationCoordinatorList) {
            if (LabVal.equals(val)) {
                return false;
            }
        }
        return true;
    }

    public List<Test> getPastTests(){
        return pastTests;
    }


    /**
     *
     * add validationCoordinator to the list
     */
    public boolean addValidationCoordinator(Test test){
        return pastTests.add(test);
    }

    public void setValidationDate(ValidationCoordinator val){
        val.getTest().setDateLaboratoryCoordinator(new Date());
    }
    /**
     *
     * save the validationCoordinator
     */
}









