package app.ui.console;

import app.domain.Store.ClinicalAnalysisLabStore;
import app.domain.model.ClinicalAnalysisLaboratory.ClinicalAnalysisLaboratory;
import app.domain.shared.ClinicalAnalysisLaboratories;
import app.domain.shared.Constants;
import app.ui.console.utils.Utils;
import auth.UserSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReceptionistUI implements Runnable {
    private UserSession sessao = new UserSession();
    private MainMenuUI main = new MainMenuUI();
    private Long lab = 0L;
    private ClinicalAnalysisLabStore labs;
    private List<ClinicalAnalysisLaboratory> labsList = new ArrayList<>();



    @Override
    public void run()
    {
        /*if (!sessao.isLoggedInWithRole(Constants.ROLE_RECEPTIONIST)) {
            System.out.println("Login as a Receptionist to proceed.");
            sessao.doLogout();
            try {
                main.run();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        while (sessao.isLoggedInWithRole(Constants.ROLE_RECEPTIONIST)) {

         */

        Scanner sc = new Scanner(System.in);

        System.out.println("Choose the Laboratory Id of your place of work.");
        for (ClinicalAnalysisLaboratory labs1 : labsList) {
            System.out.println(labs1);
        }

        this.lab = sc.nextLong();

       if (lab == 0L) {
            System.out.println("Insert the Laboratory ID of your place of work!");

        } else {


            List<MenuItem> options = new ArrayList<MenuItem>();
            options.add(new MenuItem("Register new client", new CreateClientUI()));
            options.add(new MenuItem("Register test to be performed", new RegisterTestUI()));
            int option = 0;
            do {
                option = Utils.showAndSelectIndex(options, "\n\nReceptionist Menu");

                if ((option >= 0) && (option < options.size())) {
                    options.get(option).run();
                }
            }
            while (option != -1);
       }
       //}
    }
}
