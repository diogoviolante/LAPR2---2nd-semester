package app.ui.console.loginScenes;

import app.controller.AuthController;
import app.domain.shared.Constants;
import app.ui.console.*;
import app.ui.console.utils.Utils;
import auth.mappers.dto.UserRoleDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class LogInUI implements Initializable {
    private AuthController ctrl;
    private Stage clientStage;
    private Stage lcStage;
    private Stage adminStage;


    @FXML
    private TextField textField;

    @FXML
    private PasswordField textField2;

    @FXML
    private Button loginButton;
    @FXML
    private Button xButton;


    public LogInUI()
    {
        ctrl = new AuthController();
    }


    private List<MenuItem> getMenuItemForRoles()
    {
        List<MenuItem> rolesUI = new ArrayList<>();
        rolesUI.add(new MenuItem(Constants.ROLE_ADMIN, new AdminUI()));
        rolesUI.add(new MenuItem(Constants.ROLE_LABORATORY_COORDINATOR, new LabCoordinatorUI()));
        rolesUI.add(new MenuItem(Constants.ROLE_RECEPTIONIST, new ReceptionistUI()));
        rolesUI.add(new MenuItem(Constants.ROLE_LAB_TECHNICIAN, new RegisterSampleUI()));
        rolesUI.add(new MenuItem(Constants.ROLE_CLINICAL_CHEMISTRY_TECHNOLOGIST, new ClinicalChemistryTechnologistUI()));
        rolesUI.add(new MenuItem(Constants.ROLE_SPECIALIST_DOCTOR,new SpecialistDoctorUI()));
        rolesUI.add(new MenuItem(Constants.ROLE_CLIENT, new ClientUI()));
        return rolesUI;
    }

    private boolean doLogin()
    {
        boolean success = false;

        String id = textField.getText();
        String pwd = textField2.getText();

        success = ctrl.doLogin(id, pwd);
        if (!success) {
            Alert alert= new Alert(Alert.AlertType.CONFIRMATION);

            alert.setTitle("Many Labs");
            alert.setHeaderText("Error");
            alert.setContentText("Invalid UserId and/or Password.");
            alert.show();
        }

        return success;
    }

    private void logout()
    {
        ctrl.doLogout();
    }

    private void redirectToRoleUI(List<MenuItem> rolesUI, UserRoleDTO role)
    {
        boolean found = false;
        Iterator<MenuItem> it = rolesUI.iterator();
        while (it.hasNext() && !found)
        {
            MenuItem item = it.next();
            found = item.hasDescription(role.getDescription());
            if (found)
                item.run();
        }
        if (!found)
            System.out.println("There is no UI for users with role '" + role.getDescription() + "'");
    }

    private UserRoleDTO selectsRole(List<UserRoleDTO> roles)
    {
        if (roles.size() == 1)
            return roles.get(0);
        else
            return (UserRoleDTO) Utils.showAndSelectOne(roles, "Select the role you want to adopt in this session:");
    }




    @FXML
    void loginButton(ActionEvent event){
        boolean success = doLogin();

        if (success)
        {
            List<UserRoleDTO> roles = this.ctrl.getUserRoles();
            if ( (roles == null) || (roles.isEmpty()) )
            {
                Alert alert= new Alert(Alert.AlertType.CONFIRMATION);

                alert.setTitle("Many Labs");
                alert.setHeaderText("Error");
                alert.setContentText("No role has been assigned to the user.");
                alert.show();
            }
            else
            {
                UserRoleDTO role = selectsRole(roles);
                if (!Objects.isNull(role))
                {
                    System.out.println(role.getId());
                   switch(role.getId()){
                       case Constants.ROLE_CLIENT:
                           ClientUI clientUI= new ClientUI();
                           clientUI.run();
                           clientStage.show();
                           break;
                       case Constants.ROLE_LABORATORY_COORDINATOR:
                           LabCoordinatorUI lcUi= new LabCoordinatorUI();
                           lcUi.run();
                           lcStage.show();
                           break;
                       case Constants.ROLE_CLINICAL_CHEMISTRY_TECHNOLOGIST:
                          ClinicalChemistryTechnologistUI cUI= new ClinicalChemistryTechnologistUI();
                          cUI.run();
                           break;
                       case Constants.ROLE_ADMIN:
                           AdminUI adminUI= new AdminUI();
                           adminUI.run();
                           adminStage.show();
                           break;
                       case Constants.ROLE_RECEPTIONIST:
                           ReceptionistUI rece = new ReceptionistUI();
                           rece.run();
                           break;
                       case Constants.ROLE_LAB_TECHNICIAN:
                           RegisterSampleUI sample = new RegisterSampleUI();
                           sample.run();
                           break;
                       case Constants.ROLE_SPECIALIST_DOCTOR:
                           DiagnosisUI diagnosis = new DiagnosisUI();
                           diagnosis.run();
                           break;
                   }

                }
                else
                {
                    Alert alert= new Alert(Alert.AlertType.CONFIRMATION);

                    alert.setTitle("Many Labs");
                    alert.setHeaderText("Error");
                    alert.setContentText("No role has been selected by the user.");
                    alert.show();
                }
            }
        }
        this.logout();
    }

    @FXML
    void exitWindow(ActionEvent event){
        System.exit(0);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ClientMenuScene.fxml"));
            Parent root= loader.load();

            Scene scene = new Scene(root);

            clientStage = new Stage();
            clientStage.initStyle(StageStyle.TRANSPARENT);
            clientStage.initModality(Modality.APPLICATION_MODAL);
            clientStage.setTitle("Many Labs");
            clientStage.getIcons().add((new Image("/fxml/ImageOne.jpeg")));
            clientStage.setResizable(false);
            clientStage.setScene(scene);

            //////////////////////////////////////////////////////
            FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/fxml/LcScene.fxml"));
            Parent root2= loader2.load();

            Scene scene2 = new Scene(root2);

            lcStage = new Stage();
            lcStage.initStyle(StageStyle.TRANSPARENT);
            lcStage.initModality(Modality.APPLICATION_MODAL);
            lcStage.setTitle("Many Labs");
            lcStage.getIcons().add((new Image("/fxml/ImageOne.jpeg")));
            lcStage.setResizable(false);
            lcStage.setScene(scene2);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
            FXMLLoader loader3 = new FXMLLoader(getClass().getResource("/fxml/Administrator.fxml"));
            Parent root3= loader3.load();

            Scene scene3 = new Scene(root3);

            adminStage = new Stage();
            adminStage.initStyle(StageStyle.TRANSPARENT);
            adminStage.initModality(Modality.APPLICATION_MODAL);
            adminStage.setTitle("Many Labs");
            adminStage.getIcons().add((new Image("/fxml/ImageOne.jpeg")));
            adminStage.setResizable(false);
            adminStage.setScene(scene3);


        } catch (IOException e) {
            Alert alert= new Alert(Alert.AlertType.CONFIRMATION);

            alert.setTitle("Many Labs");
            alert.setHeaderText("Error");
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }
}
