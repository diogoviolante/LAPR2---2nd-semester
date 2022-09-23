package app.domain.model;

import auth.domain.model.Email;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

public class TestTest {
    TesteType type = new TesteType("test", "testof", "collecting", "12fg5", new ArrayList<>());
    Client cliente = new Client("diogo", "1234567891234567", 12345678912L, 1234567891L, 1234567891, new Date("2002/3/30"), "Client", new Email("ds@gmail.com"),"yauuuu");
    app.domain.model.Test teste = new app.domain.model.Test(cliente, "000000000001", "123456789123", type, new ArrayList<>(), "12345", new Date());

    @Test
    public void getClient() {
        assertEquals(cliente, teste.getClient());
    }

    @Test
    public void getType() { assertEquals(type, teste.getType()); }

    @Test
    public void getParameters() {
        assertEquals(new ArrayList<>(), teste.getParameters());
    }

    @Test
    public void getNhsCode() {
        assertEquals("123456789123", teste.getNhsCode());
    }

    @Test
    public void getCode() {
        assertEquals( "000000000001",teste.getCode());
    }

    @Test
    public void getLabId() {
        assertEquals("12345", teste.getLabId());
    }

    @Test
    public void validateNHSCode() {
        teste.validateNHSCode(teste.getNhsCode());
    }

    @Test (expected = IllegalArgumentException.class)
    public void validateNHSCodeWrong() {
        app.domain.model.Test test2 = new app.domain.model.Test(cliente, "000000000001", "123456789123sdfsdfsfds", type, new ArrayList<>(), "12345L", new Date());
        test2.validateNHSCode(test2.getNhsCode());
    }

    @Test
    public void getDate() { Date result = teste.getDate(); }

    @Test
    public void testToString() { String result = teste.toString(); }


    @Test
    public void validateClient() { teste.validateClient(cliente); }



}