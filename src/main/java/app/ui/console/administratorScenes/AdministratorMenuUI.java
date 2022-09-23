package app.ui.console.administratorScenes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdministratorMenuUI implements Initializable {

    private Stage reportStage;
    private Scene scene3;
    private Parent root3;


    @FXML
    private Button goToReportSceneButton;

    @FXML
    private Button outButton;


    @FXML
    void switchToReport(ActionEvent event) { reportStage.show(); }


    @FXML
    void exitWindow (ActionEvent event) { System.exit(0); }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FXMLLoader loader3 = new FXMLLoader(getClass().getResource("/fxml/Report.fxml"));
        Parent root3= null;
        try {
            root3 = loader3.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene3 = new Scene(root3);

        reportStage = new Stage();
        reportStage.initStyle(StageStyle.TRANSPARENT);
        reportStage.initModality(Modality.APPLICATION_MODAL);
        reportStage.setTitle("Many Labs");
        reportStage.getIcons().add((new Image("/fxml/ImageOne.jpeg")));
        reportStage.setResizable(false);
        reportStage.setScene(scene3);

    }
}
