package app.ui.console.clienteScenes;

import app.controller.App;
import app.controller.CheckResultController;
import app.domain.model.*;
import auth.domain.model.Email;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheckResults {
    private Email email;
    private Client client1;
    private String code;
    private Scanner sc = new Scanner(System.in);
    private int option = 1;
    private List<AllDates> datesResult = new ArrayList<>();
    private CheckResultController controller = new CheckResultController();
    private Company company = App.getInstance().getCompany();

    public CheckResults(){
        email = this.company.getAuthFacade().getCurrentUserSession().getUserId();
        client1 = controller.getClient(email);
        datesResult = controller.getListOrdered(client1, datesResult);
    }


    private PipedInputStream in= new PipedInputStream();
    private PipedOutputStream out = new PipedOutputStream();
    @FXML
    private Button xButton;

   @FXML
   private TextArea tests;

    @FXML
    void exitWindow(){ System.exit(0); }

    public void results(){
        for (Results result: controller.getResultList()) {
            if (code.equals(result.getCode())) {
                tests.setText(result.toString());
            }
        }

        for (Diagnosis diagnosis: controller.getDiagnosisList()){
            if (code.equals(diagnosis.getCode())){
                tests.setText(diagnosis.toString());
            }
        }
    }
}
