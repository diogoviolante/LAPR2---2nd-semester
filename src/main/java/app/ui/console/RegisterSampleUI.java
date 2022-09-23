package app.ui.console;

import app.controller.RegisterSampleController;
import app.domain.Store.TestStore;
import java.util.Scanner;


public class RegisterSampleUI implements Runnable {


    private TestStore storeTest = new TestStore();
    private RegisterSampleController registSampleController;
    Scanner ler = new Scanner(System.in);



    public RegisterSampleUI() {
        this.registSampleController = new RegisterSampleController();
    }


    public void run(){
        try{
            System.out.println("\n");
            System.out.println("---------------Medical Lab Technician Menu--------------");
            System.out.println();
            System.out.println("Existent tests in the system without samples:");
            System.out.println(this.storeTest.getTestList());
            if (this.storeTest.getTestList().isEmpty()){
                System.out.println("No test available!");
            }else {
                System.out.println("Please select the code of the test:");
                String code = ler.next();
                if (this.registSampleController.getTestByCode(code) == null) {
                    System.out.println("There is no test with the inserted code.");
                } else {
                    registSampleController.setTest(this.registSampleController.getTestByCode(code));
                    System.out.println("Test was selected with success!\n");
                    System.out.println("How many samples do you want to regist?");
                    int number = ler.nextInt();
                    System.out.println();
                    for (int i = 1; i <= number; i++) {
                        if (this.registSampleController.saveSample(this.registSampleController.createSample(code))) {
                            System.out.println("The sample " + i + " was correctly created and associated with the selected test.\n");
                        } else {
                            System.out.println("Failed to add the sample!\n");
                        }
                    }
                }
            }
        }catch (IllegalArgumentException | NullPointerException illegalArgumentException){
            System.out.println(illegalArgumentException.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

