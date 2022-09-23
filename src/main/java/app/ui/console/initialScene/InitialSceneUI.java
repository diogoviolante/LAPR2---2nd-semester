package app.ui.console.initialScene;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class InitialSceneUI implements Initializable {
    private Stage stageLogIn;

    @FXML
    Button button1;
    @FXML
    Button button2;
    @FXML
    Button xButton;

    @FXML
    void logIn(ActionEvent event){
        stageLogIn.show();
    }

    @FXML
    void showDevelopmentTeam(ActionEvent event){
        Alert alert= new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle("Many Labs");
        alert.setHeaderText("Development Team");
        alert.setContentText("Pedro Sousa - 1201428@isep.ipp.pt \n" + "Diogo Violante - 1201284@isep.ipp.pt \n" + "Gonçalo Teixeira - 1200882@isep.ipp.pt \n" + "João Oliveira - 1201183@isep.ipp.pt \n");
        alert.show();
    }

    @FXML
    void exitWindow(ActionEvent event){ System.exit(0); }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LoginScene.fxml"));
            Parent root= loader.load();

            Scene scene = new Scene(root);

            stageLogIn = new Stage();
            stageLogIn.initStyle(StageStyle.TRANSPARENT);
            stageLogIn.initModality(Modality.APPLICATION_MODAL);
            stageLogIn.setTitle("Many Labs");
            stageLogIn.getIcons().add((new Image("/fxml/ImageOne.jpeg")));
            stageLogIn.setResizable(false);
            stageLogIn.setScene(scene);


        } catch (IOException e) {
            Alert alert= new Alert(Alert.AlertType.CONFIRMATION);

            alert.setTitle("Many Labs");
            alert.setHeaderText("Error");
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }
}
