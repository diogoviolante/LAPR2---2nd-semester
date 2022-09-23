
package app.domain.model;

import app.domain.Store.TestStore;
import auth.domain.model.Email;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ValidationCoordinatorTest {

    List<Parameter> parameterList = new ArrayList<>();
    TesteType type = new TesteType("test", "testof", "collecting", "12fg5", new ArrayList<>());
    Client yau= new Client("rosinha", "1234567891234567",12345678911L,1234567891L,1234567891L,new Date("27/05/2002"),"Client", new Email("rei@rei.pt"),"yauuuu");
    TestStore store = new TestStore();
    app.domain.model.Test testee = store.createTest(yau, "12345", "123456789412", type, parameterList, "12345", new Date());
    app.domain.model.Test test= new app.domain.model.Test(yau, "000000000001","123456789111",type, parameterList, "12345", new Date("27/05/2002"));



    @Test
    public void ValidateTest() { store.saveTest(testee); }

    @Test
    public void testEquals() { Boolean result = testee.equals(test); }

}
