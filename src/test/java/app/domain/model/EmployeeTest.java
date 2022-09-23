package app.domain.model;

import app.controller.RegisterEmployeeUIController;
import auth.domain.model.Email;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class EmployeeTest {

    Employee newEmployee = new Employee("Receptionist", "PS00001", "Pedro Sousa", "100 rua Egas Moniz", new Email("123@isep.pt") , "12345678911", 1234);


    @Test
    public void validateRole1() {
        newEmployee.validateRole("Receptionist");
    }
    @Test(expected = IllegalArgumentException.class)
    public void validateRole2() {
       newEmployee.validateRole("");
    }
    @Test(expected = IllegalArgumentException.class)
    public void validateRole3() { newEmployee.validateRole("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"); }
    @Test
    public void validateRole4() { newEmployee.validateRole("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"); }



    @Test
    public void validateName1() {
        String expresult = "Pedro Sousa";
        String result = newEmployee.getName();
        assertEquals(expresult, result);
    }
    @Test(expected = IllegalArgumentException.class)
    public void validateName2() {
        newEmployee.validateName("");
    }
    @Test(expected = IllegalArgumentException.class)
    public void validateName3() {
        newEmployee.validateName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }
    @Test()
    public void validateName4() { newEmployee.validateName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"); }



    @Test
    public void validateAddress1() {
        newEmployee.validateAddress("100 Egas Moniz");
    }
    @Test(expected = IllegalArgumentException.class)
    public void validateAddress2() {
        newEmployee.validateAddress("");
    }
    @Test(expected = IllegalArgumentException.class)
    public void validateAddress3() { newEmployee.validateAddress("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"); }
    @Test()
    public void validateAddress4() { newEmployee.validateAddress("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"); }



    @Test
    public void validatePhone_Number1() {
        newEmployee.validatePhoneNumber("12345678911");
    }
    @Test(expected = IllegalArgumentException.class)
    public void validatePhone_Number2() {
        newEmployee.validatePhoneNumber("");
    }
    @Test(expected = IllegalArgumentException.class)
    public void validatePhone_Number3() {
        newEmployee.validatePhoneNumber("111111111111111");
    }



    @Test
    public void validateSoc() {
        newEmployee.validateSoc(1234);
    }
    @Test(expected = IllegalArgumentException.class)
    public void validateSoc2() {
        newEmployee.validateSoc(10);
    }
    @Test(expected = IllegalArgumentException.class)
    public void validateSoc3() {
        newEmployee.validateSoc(1000000000);
    }
    @Test
    public void validateSoc4() {
        newEmployee.validateSoc(1000);
    }
    @Test
    public void validateSoc5() {
        newEmployee.validateSoc(9999);
    }



    @Test
    public void validateIndexNumber() {
        newEmployee.validateIndexNumber(123456);
    }
    @Test(expected = IllegalArgumentException.class)
    public void validateIndexNumber2() {
        newEmployee.validateIndexNumber(10);
    }
    @Test(expected = IllegalArgumentException.class)
    public void validateIndexNumber3() {
        newEmployee.validateIndexNumber(1000000000);
    }
    @Test
    public void validateIndexNumber4() {
        newEmployee.validateIndexNumber(100000);
    }
    @Test
    public void validateIndexNumber5() {
        newEmployee.validateIndexNumber(999999);
    }




    @Test
    public void generateID() {
        RegisterEmployeeUIController controller = new RegisterEmployeeUIController();
        String result = controller.generateID("Pedro daniel Sousa");
        String expresult = "PDS00001";
        assertEquals(expresult, result);
    }




    @Test
    public void getRole() {
        String result = newEmployee.getRole();
        String expresult = "Receptionist";
        assertEquals(result, expresult);
    }




    @Test
    public void getEmployeeID() {
        String result = newEmployee.getEmployeeID("Pedro Sousa");
        String expresult = "PS00001";
        assertEquals(result, expresult);
    }




    @Test
    public void getName() {
        String result = newEmployee.getName();
        String expresult = "Pedro Sousa";
        assertEquals(result, expresult);
    }



    @Test
    public void getAddress() {
        String result = newEmployee.getAddress();
        String expresult = "100 rua Egas Moniz";
        assertEquals(result, expresult);
    }



    @Test
    public void getEmail() {
        Email result = newEmployee.getEmail();
        Email expresult = new Email("123@isep.pt");
        assertEquals(result, expresult);
    }





    @Test
    public void getPhoneNumber() {
        String result = newEmployee.getPhoneNumber();
        String expresult = "12345678911";
        assertEquals(result, expresult);
    }




    @Test
    public void getSoc() {
        Long result = newEmployee.getSoc();
        Long expresult = 1234L;
        assertEquals(result, expresult);
    }




    Employee newEmployee2 = new Employee("Receptionist", "PS00001", "Pedro Sousa", "100 rua Egas Moniz", new Email("123@isep.pt") , "12345678911", 1234, 123456);

    @Test
    public void getIndexNumber() {
        Long result = newEmployee2.getIndexNumber();
        Long expresult = 123456L;
        assertEquals(result, expresult);
    }



    @Test
    public void testToString() { String result = newEmployee.toString(); }


}