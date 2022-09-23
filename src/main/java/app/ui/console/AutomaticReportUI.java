package app.ui.console;

import app.domain.model.ReportNHS;

import java.util.TimerTask;

public class AutomaticReportUI extends TimerTask {




    @Override
    public void run() {
        ReportNHS.writeUsingFileWriter("\n\n\n\n");
        String day = "--------------------------------------------------------------------------------";
        ReportNHS.writeUsingFileWriter(day);
        String report = "\nAutomatically report made at 6am\n\n";
        ReportNHS.writeUsingFileWriter(report);

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
