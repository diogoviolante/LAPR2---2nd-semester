package app.ui.console.clienteScenes;

import app.controller.App;
import app.controller.CheckResultController;
import app.domain.model.*;
import auth.domain.model.Email;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class CheckCode {
    private Email email;
    private Client client1;
    private String code;
    private Scanner sc = new Scanner(System.in);
    private int option = 1;
    private List<AllDates> datesResult = new ArrayList<>();
    private CheckResultController controller = new CheckResultController();
    private Company company = App.getInstance().getCompany();

    public CheckCode(){
        email = this.company.getAuthFacade().getCurrentUserSession().getUserId();
        client1 = controller.getClient(email);
        datesResult = controller.getListOrdered(client1, datesResult);
    }

@FXML
private Button xButton;
@FXML
private Button checkButton;
@FXML
private TextField textField;

@FXML
public void checkCode(){
    String code = textField.getText();
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
}

@FXML
    public void exitWindow(){
    System.exit(0);
}


}
