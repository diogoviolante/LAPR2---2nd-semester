package app.ui.console;

import app.controller.App;
import app.controller.CheckResultController;
import app.domain.model.*;
import app.domain.shared.*;
import auth.UserSession;
import auth.domain.model.Email;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.util.*;

public class CheckResultsUI implements Runnable {
    private Email email;
    private Client client1;
    private String code;
    private Scanner sc = new Scanner(System.in);
    private int option = 1;
    private List<AllDates> datesResult = new ArrayList<>();
    private CheckResultController controller = new CheckResultController();
    private Company company = App.getInstance().getCompany();

    public CheckResultsUI(){
        email = this.company.getAuthFacade().getCurrentUserSession().getUserId();
        client1 = controller.getClient(email);
        datesResult = controller.getListOrdered(client1, datesResult);
    }




    @Override
    public void run() {
       for (AllDates d: datesResult){
           System.out.println(d.toString());
       }
        do {
            System.out.println("Please insert the code of the test that has the results you want to check.");
            code = sc.next();

            for (Results result: controller.getResultList()) {
                if (code.equals(result.getCode())) {
                    System.out.println("\n"+result.toString());
                }
            }

            for (Diagnosis diagnosis: controller.getDiagnosisList()){
                if (code.equals(diagnosis.getCode())){
                    System.out.println(diagnosis.toString());
                }
            }

            System.out.println("Do you wish to continue?" +
                    "\n1-Yes" +
                    "\n0-No");
            option = sc.nextInt();
        }while (option == 1);


    }
}
