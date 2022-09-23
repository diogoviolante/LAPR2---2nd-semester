package app.domain.Store;

import app.domain.model.Client;
import app.domain.model.Company;
import app.domain.model.TesteType;
import app.domain.model.ValidationCoordinator;
import app.domain.shared.PastTests;
import app.dto.validationCoordinatorDto;
import auth.domain.model.Email;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class AvailableTestStoreTest implements PastTests {


    Company company= new Company("yau");
    //AvailableTestStore availableTestStore = new AvailableTestStore();
    TestStore testStore = new TestStore();
    validationCoordinatorDto dto = new validationCoordinatorDto(testStore);
    List<TestStore> testStoreList = new ArrayList<>();
    List<ValidationCoordinator> ValidationCoordinatorList;
    ValidationCoordinator LabVal;
    Client cliente = new Client("diogo", "1234567891234567", 12345678912L, 1234567891L, 1234567891, new Date("2002/3/30"), "Client", new Email("ds@gmail.com"),"yauuuu");
    TesteType type = new TesteType("test", "testof", "collecting", "12fg5", new ArrayList<>());
    app.domain.model.Test teste = new app.domain.model.Test(cliente, "000000000001", "123456789123", type, new ArrayList<>(), "12345", new Date());


/*
    @Test
    public void createValidationCoordinator() {
        availableTestStore.createValidationCoordinator(dto);
    }

    @Test
    public void validateValidationCoordinator() {
        availableTestStore.validateValidationCoordinator(LabVal.createValidationCoordinator(dto));
    }

    @Test
    public void getPastTests() {
        availableTestStore.getPastTests();
    }

    @Test
    public void addValidationCoordinator() {
        availableTestStore.addValidationCoordinator(teste);
    }

    @Test
    public void setValidationDate() {
        availableTestStore.setValidationDate(availableTestStore.createValidationCoordinator(dto));
    }

 */
}