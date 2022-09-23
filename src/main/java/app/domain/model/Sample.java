package app.domain.model;

import app.domain.shared.ListDates;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import java.io.File;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;


public class Sample implements ListDates, Serializable {


    /**
     * Calendar instance
     */
    Calendar calendar;


    /**
     * Date of the sample
     */
    private Date dateSamplesCollected;


    /**
     * code of the test.
     */
    private String code;


    /**
     * Creates sample
     *
     * @throws Exception exception
     */
    public Sample(String code) throws Exception {
        this.calendar = Calendar.getInstance();
        this.dateSamplesCollected = calendar.getTime();
        this.code = code;
        generateEAN13BarcodeImage(String.valueOf(code));
    }


    /**
     * Generates barcode
     *
     * @param barcodeText the barcode text
     */
    public void generateEAN13BarcodeImage(String barcodeText) throws Exception {
        Barcode barcode = BarcodeFactory.createEAN13(barcodeText);
        barcode.setPreferredBarHeight(100);
        BarcodeImageHandler.saveJPEG(barcode, new File("OutputFiles//Barcodes/Barcode_" + barcodeText + ".jpeg"));
    }




    /**
     * Date of the sample
     *
     * @return date
     */
    public Date getDateSamplesCollected() {
        return dateSamplesCollected;
    }



    /**
     * Textual description of sample
     *
     * @return string of sample
     */
    @Override
    public String toString() {
        return "Sample{" +
                "date=" + dateSamplesCollected +
                ", barcodeText='" + code + '\'' +
                '}';
    }



    /**
     * Returns string with barcode
     *
     * @return barcode
     */
    public String getCode() {
        return code;
    }



    public void setCode(String code) {
        this.code = code;
    }



}



