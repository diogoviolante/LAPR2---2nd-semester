package app.domain.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReportNHS {
    public ReportNHS() {
    }



    public static void writeUsingFileWriter(String data) {
        File file = new File("./NHS/NHSReport.txt");
        FileWriter fr = null;

        try {
            fr = new FileWriter(file,true);
            fr.write(data);
        } catch (IOException var12) {
            var12.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException var11) {
                var11.printStackTrace();
            }

        }


    }

}
