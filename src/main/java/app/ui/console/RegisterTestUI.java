package app.ui.console;

import app.controller.App;
import app.controller.RegisterTestController;
import app.domain.model.*;
import app.domain.shared.Constants;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class RegisterTestUI implements Runnable {
    private String labId;
    private RegisterTestController controller;
    private Company company = new Company(Constants.PARAMS_COMPANY_DESIGNATION);
    private Long taxNumber;
    private String code;
    private String nhsNumber;
    private Client client;
    private TesteType type;
    private String cat;
    private List<Parameter> parameters = new ArrayList<>();
    private String para;
    private boolean boo = false;
    private Date date = new Date();

    public RegisterTestUI() {this(App.getInstance().getCompany());}

    public RegisterTestUI(Company company) {
        this.company = company;
        this.controller = new RegisterTestController();
    }


    @Override
    public void run() {
        Scanner ler = new Scanner(System.in);

        do {
            System.out.println("Please insert the Tax Identification Number of the client.");
            taxNumber = ler.nextLong();

            try {
                if (String.valueOf(taxNumber).length() != Constants.VAL_NHS) {
                    throw new IllegalArgumentException("Insert a valid Tax Identification Number.");
                }

                if (this.company.getClient(taxNumber) == null) {
                    throw new IllegalArgumentException("The Tax Identification Number inserted does not correspond to a registered client.");
                }

                boo = true;
            } catch (IllegalArgumentException e) {
                boo = false;
                e.printStackTrace();
            }
        }while (!boo);
        this.client = this.company.getClient(taxNumber);

        System.out.println("Please choose the code of the type of test.");
        System.out.println(controller.getTypeList());
        ler.nextLine();
        code = ler.nextLine();
        for (TesteType testeType: controller.getTypeList()){
            if (code.equals(testeType.getCode())){
                type = testeType;
            }
        }


        System.out.println("Please select the parameters of the test. \n(Type \"0\" when you finish.)");
        for (Parameter param: controller.getParametersList()){
            System.out.println(param);
        }

        para = ler.next();
        while (!para.equals("0")) {
            for (Parameter param: controller.getParametersList()){
                if (para.equals(param.getParameterCode())){
                    parameters.add(param);
                }
            }
            para = ler.next();
        }



        System.out.println("Please insert the NHS code of the test.");
        nhsNumber = ler.next();

        System.out.println("Please insert the Laboratory ID of your place of work.");
        //ir buscar aos atributos.
        labId = ler.nextLine();

        code = this.controller.generateCode();
        this.controller.saveTest(this.controller.registerTest(client, code, nhsNumber, type, parameters, labId, date));

        System.out.println("Registered Tests:");
        for (Test tests: this.controller.getTestList()){
            System.out.println(tests);
        }
    }
}
