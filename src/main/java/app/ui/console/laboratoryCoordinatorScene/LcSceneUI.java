package app.ui.console.laboratoryCoordinatorScene;
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

public class LcSceneUI implements Initializable {
private Stage LCstage;
@FXML
    private Button ImportCVSfilesButton;
@FXML
    private Button xButton;
@FXML
    private Button performanceButton;
@FXML
    void ImportCVSfilesButton(ActionEvent event){
LCstage.show();
}
@FXML
 void performanceButton(ActionEvent event){
    LCstage.show();
}

@FXML
void exitWindow(javafx.event.ActionEvent event){
            System.exit(0);
        }
@FXML
 void ImportCVSfilesButton(){

}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CVSfiles.fxml"));
            Parent root= loader.load();

            Scene scene = new Scene(root);

            LCstage = new Stage();
            LCstage.initStyle(StageStyle.TRANSPARENT);
            LCstage.initModality(Modality.APPLICATION_MODAL);
            LCstage.setTitle("Many Labs");
            LCstage.getIcons().add((new Image("/fxml/ImageOne.jpeg")));
            LCstage.setResizable(false);
            LCstage.setScene(scene);


        } catch (IOException e) {
            Alert alert= new Alert(Alert.AlertType.CONFIRMATION);

            alert.setTitle("Many Labs");
            alert.setHeaderText("Error");
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }
}
