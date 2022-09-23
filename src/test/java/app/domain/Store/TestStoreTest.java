package app.domain.Store;

import app.domain.model.Client;
import app.domain.model.TesteType;
import app.domain.shared.ListDates;
import app.domain.shared.ListofTests;
import auth.domain.model.Email;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

public class TestStoreTest implements ListDates, ListofTests {
    Client client = new Client ("diogo", "1234567891234567", 12345678912L, 1234567891L, 1234567891, new Date("2002/3/30"), "Client", new Email("ds@gmail.com"),"yauuuu");
    TestStore store = new TestStore();
    TesteType type = new TesteType("test", "testof", "collecting", "12fg5", new ArrayList<>());

    @Test
    public void createTest() { store.createTest(client, "0000000001", "123456789123", type, new ArrayList<>(), "12345L", new Date()); }

    @Test (expected = IllegalArgumentException.class)
    public void createTestWrong1() { store.createTest(client, "0000000001", "123456789123fghjghj", type, new ArrayList<>(), "12345L", new Date()); }

    @Test
    public void generateCode() {
        store.generateCode();
    }

    @Test
    public void validateTest() { assertTrue(store.validateTest(store.createTest(client, "0000000001", "123456789123", type, new ArrayList<>(), "12345L", new Date()))); }

    @Test
    public void getDates() {
        assertEquals(store.getDates(), datesList);
    }

    @Test
    public void getTestList() {
        assertEquals(store.getTestList(), listOfTests);
    }

}