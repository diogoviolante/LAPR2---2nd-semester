package app.ui.console;

import app.controller.App;
import app.controller.RegisterResultController;
import app.domain.model.Company;
import app.domain.model.Parameter;
import app.domain.model.Test;
import app.domain.model.TesteType;
import app.domain.shared.Constants;
import app.domain.shared.ListOfResults;
import app.domain.shared.ListofTests;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class RegisterResultUI implements Runnable, ListOfResults, ListofTests {
private Company company= App.getInstance().getCompany();
    /**
     * Barcode String of the Sample
     */
    private static String barCodeString;
    /**
     * Test Type of the Sample
     */
    private static TesteType testType;
    /**
     * AccessKey to enter in record mode
     */
    private static int accessKey;
    /**
     * Array with the parameters
     */
    private static String[] parameters_External_2API = {"HB000", "WBC00", "PLT00", "RBC00", "MCV00", "MCH00", "MCHC0", "ESR00"};
    /**
     * Value of the parameters
     */
    private static double valueParameter;
    /**
     * IgGan string
     */
    private static String igGAN = "IgGAN";

    /**
     * Result of the test.
     */
    private String result;

    /**
     * Code of te test
     */
    private String code;

    private Date test = new Date();

    /**
     * Scanner to read the line
     */
    Scanner sc = new Scanner(System.in);
    /**
     * Instance of recordResultsController
     */
    private RegisterResultController recordResultsController;

    public RegisterResultUI() {
        this.recordResultsController = new RegisterResultController();
    }


    String erro = "ERROR: Was not added";
    String access = "Enter the accessKey:";
    String errAcces = "Error in the accessKey";
    String success = "Added successfully!";

    @Override
    public void run() {


        try {
            System.out.println(" Register Test Results Menu");
            System.out.println("Introduce the BarCode that you want to record:");
            barCodeString = sc.next();
            if (recordResultsController.validateBarcodeString(barCodeString)) {
                TesteType testType1 = recordResultsController.getTestType(barCodeString);
                for (Test uai: listOfTests){
                    System.out.println(uai);
                }
                String testType = testType1.getName();

                code = recordResultsController.getTest(barCodeString).getCode();
                if (testType.equalsIgnoreCase("Covid")) {
                    System.out.println(access);
                    accessKey = sc.nextInt();
                    if (accessKey == 12345) {
                        System.out.println("-----Parameter Category: Covid analysis(1234)-----");
                        System.out.println("Antibodies count(IgGAN):");
                        valueParameter = sc.nextDouble();
                        result = recordResultsController.covidAPI1(valueParameter, accessKey, igGAN);
                        resultsList.add(recordResultsController.createResult(testType, "IgGAN", code, result, valueParameter));
                        System.out.println(success);
                        recordResultsController.setDateResultToTest(recordResultsController.getTest(barCodeString));

                    } else {

                        System.out.println(errAcces);
                    }
                } else if (testType.equalsIgnoreCase("Blood")) {
                    System.out.println(access);
                    accessKey = sc.nextInt();
                    if (accessKey == 12345) {
                        System.out.println("-----Parameter Category: Blood analysis(1212)-----");
                        System.out.println("Available parameters:" + Constants.RBC + "/" + Constants.WBC + "/" + Constants.PLT
                                + "/" + Constants.HB + "/" + Constants.MCV + "/" + Constants.MCH + "/" + Constants.MCHC + "/"
                                + Constants.ESR);
                        for (int i = 0; i < parameters_External_2API.length; i++) {
                            System.out.println("Insert the value of " + parameters_External_2API[i] + ":");
                            valueParameter = sc.nextDouble();

                            result = recordResultsController.bloodAPI3(valueParameter, parameters_External_2API[i], accessKey);
                            resultsList.add(recordResultsController.createResult(testType, parameters_External_2API[i], code, result, valueParameter));
                            System.out.println(success);
                            recordResultsController.setDateResultToTest(recordResultsController.getTest(barCodeString));
                        }
                    } else {
                        System.out.println(errAcces);
                    }
                } else {
                    List<Parameter> params = recordResultsController.getTest(barCodeString).getParameters();
                    System.out.println(access);
                    accessKey = sc.nextInt();
                    if (accessKey == 12345) {
                        for (Parameter parameters : params) {
                            System.out.println("Value of " + parameters + ":");
                            valueParameter = sc.nextDouble();

                            result = recordResultsController.bloodAPI3(valueParameter, String.valueOf(parameters), accessKey);
                            resultsList.add(recordResultsController.createResult(testType, String.valueOf(parameters), code, result, valueParameter));
                            System.out.println(success);
                            recordResultsController.setDateResultToTest(recordResultsController.getTest(barCodeString));
                        }
                    } else {
                        System.out.println(errAcces);
                    }
                }
            } else {
                System.out.println("The Barcode doesn't exits!");
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        } catch (Exception e) {
            System.out.println("Unkown Error recording the test Results:\n" +
                    e.getMessage());
        }
    }
}
