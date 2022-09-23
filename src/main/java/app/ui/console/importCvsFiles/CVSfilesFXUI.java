package app.ui.console.importCvsFiles;

import app.controller.CVSfilesController;
import app.domain.model.CVSfiles;
import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;

public class CVSfilesFXUI {

@FXML
    private TextField textField;
@FXML
    private CVSfilesController cvSfilesController;
@FXML
 private Button exitButton;
    @FXML
    void exitWindow(ActionEvent event){
        System.exit(0);
    }
@FXML
  private Button file1Button;
    @FXML
    private Button file2Button;
@FXML
private CVSfiles cvSfiles;
    @FXML
    private Button file3Button;
public CVSfilesFXUI(){
  this.cvSfilesController= new CVSfilesController();
this.cvSfiles=new CVSfiles();
}
@FXML
    void file1Button() throws FileNotFoundException {


    cvSfilesController.AddTest(1);
}
    @FXML
    void file2Button() throws FileNotFoundException {


        cvSfilesController.AddTest(2);
    }
    @FXML
    void file3Button() throws FileNotFoundException {


        cvSfilesController.AddTest(3);
    }
}
