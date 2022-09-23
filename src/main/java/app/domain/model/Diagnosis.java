package app.domain.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Diagnosis implements Serializable {

    /**
     * Report of the test that includes the diagnosis
     */
    private static String report;

    /**
     * Date instance
     */
    private Date date;



    /**
     * code of the test.
     */
    private String code;

    /**
     * Creates Diagnosis
     *
     *
     */
    public Diagnosis(String report,Date date, String code) {
        validateReport(report);
        this.report = report;
         this.date=date;
         this.code = code;
    }
    /**
     * return report
     */
    public static String getReport() {
        return report;
    }

    /**
     *return date
     */
    public Date getDate() {
        return date;
    }

    public String getCode() {
        return code;
    }

    /**
     * Method used to count the words on the report
     */
    public final String[] countWords() {

        String x = getReport();
        if (x == null) {
            return null;
        }
        String y[] = x.split(" ");

        return y;
    }

    /**
     * Method to verify if the report is valid
     */
    public final void validateReport(String report) {
        String numberwords[] = countWords();
        if (numberwords == null) {
            return;
        }
        if (numberwords.length > 400) {
            throw new IllegalArgumentException("Invalid report, please insert a report with less than 400 words");
        }
    }
    /**
     * Method that decides how the object(Diagnosis) will be showed
     */
    @Override
  public String toString() {
        return String.format("report-%s", report);
    }

    //@Override
    //public boolean equals(Object o) {
        //if (this == o) return true;
        //if (o == null || getClass() != o.getClass()) return false;
        //Diagnosis newDiagnosis = (Diagnosis) o;
      //  return Objects.equals(report, newDiagnosis.report);
    //}

//@Override
    //public int hashCode(){
  //      return Objects.hash(report);
//}
}
