package app.ui.console.administratorScenes;

import app.domain.model.ReportNHS;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import java.util.TimerTask;


public class ReportUI extends TimerTask {

    private Stage reportStage;
    private Scene scene4;
    private Parent root4;

    @FXML
    private Button outButton;

    @FXML
    private DatePicker firstDate;

    @FXML
    private DatePicker lastDate;

    @FXML
    private ComboBox historicalPointsNumber;

    @FXML
    private CheckBox simpleLinearRegression;

    @FXML
    private CheckBox multilinearRegression;

    @FXML
    private CheckBox positiveTests;

    @FXML
    private CheckBox averageAge;

    @FXML
    private Button sendReport;



    @FXML
    void exitWindow (ActionEvent event) { System.exit(0); }


    @FXML
    void setFirstDate (ActionEvent event) {


    }

    @FXML
    void setLastDate (ActionEvent event) {

    }

    @FXML
    void setSimpleLinearRegression (ActionEvent event) {

    }

    @FXML
    void setMultilinearRegression(ActionEvent event) {

    }

    @FXML
    void setNumberTests (ActionEvent event) {

    }


    @FXML
    void setAverageAge (ActionEvent event) {

    }


    @FXML
    void setSendReport (ActionEvent event) {

    }





    @Override
    public void run() {
        ReportNHS.writeUsingFileWriter("\n\n\n\n");
        String day = "--------------------------------------------------------------------------------";
        ReportNHS.writeUsingFileWriter(day);

        String regressionModel = "The regression model fitted using data from the interval\n";
        ReportNHS.writeUsingFileWriter(regressionModel);
        //^y=âx+^b


        ReportNHS.writeUsingFileWriter("R2 = \n" );
        ReportNHS.writeUsingFileWriter("R2 adjusted = \n");
        ReportNHS.writeUsingFileWriter("R = \n");


        String hypoths = "\n\nHypothesis tests for regression coefficients\n";
        ReportNHS.writeUsingFileWriter(hypoths);
        ReportNHS.writeUsingFileWriter("t_obs = \n");

        String anova = "\n\nSignificance model with Anova";
        ReportNHS.writeUsingFileWriter(anova);
        String anovaTable = "\n               df	SS		MS		F";
        ReportNHS.writeUsingFileWriter(anovaTable);

        String anovaReg = "\nRegression               ";
        ReportNHS.writeUsingFileWriter(anovaReg);

        String anovaRes = "\nResidual                 ";
        ReportNHS.writeUsingFileWriter(anovaRes);

        String anovaTot = "\nTotal                    ";
        ReportNHS.writeUsingFileWriter(anovaTot);



        String predictionValues = "\n\nDate           Number of OBSERVED positive cases          Number of ESTIMATED positive cases       95% intervals";
        ReportNHS.writeUsingFileWriter(predictionValues);


        ReportNHS.writeUsingFileWriter("\n");
        ReportNHS.writeUsingFileWriter(day);

    }


}
