package app.dto;

import app.domain.Store.TestStore;
import app.domain.model.TesteType;

public class validationCoordinatorDto extends TestStore {
    private TestStore test;
    public validationCoordinatorDto (TestStore test){
        this.test=test;
    }

    public TestStore getTest() {
        return this.test;
    }
}
