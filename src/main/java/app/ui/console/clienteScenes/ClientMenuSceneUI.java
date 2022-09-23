package app.ui.console.clienteScenes;

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

public class ClientMenuSceneUI implements Initializable {
    public Stage resultStage;
    public Stage updateStage;

    @FXML
    private Button resultButton;
    @FXML
    private Button updateButton;
    @FXML
    private Button xButton;

    @FXML
    void checkResult(){
        resultStage.show();
    }

    @FXML
    void updateData(){

    }

    @FXML
    void exitWindow(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CheckResultScene.fxml"));
            Parent root= loader.load();

            Scene scene = new Scene(root);

            resultStage = new Stage();
            resultStage.initStyle(StageStyle.TRANSPARENT);
            resultStage.initModality(Modality.APPLICATION_MODAL);
            resultStage.setTitle("Many Labs");
            resultStage.getIcons().add((new Image("/fxml/ImageOne.jpeg")));
            resultStage.setResizable(false);
            resultStage.setScene(scene);

            //////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////////////////////////////////////////


        } catch (IOException e) {
            Alert alert= new Alert(Alert.AlertType.CONFIRMATION);

            alert.setTitle("Many Labs");
            alert.setHeaderText("Error");
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }
}
