package app.domain.model;

import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import static org.junit.Assert.*;

public class SampleTest {

    Sample sample = new Sample("123456789101");
    Date data = new Date("2002/11/14");

    public SampleTest() throws Exception {
    }


    @Test
    public void generateEAN13BarcodeImage() throws BarcodeException, OutputException, IOException {
        String ARROZ = sample.getCode();
        Barcode barcode1 = BarcodeFactory.createEAN13(String.valueOf(ARROZ));
        barcode1.setPreferredBarHeight(100);
        BarcodeImageHandler.saveJPEG(barcode1, new File("Barcodes/Barcode_" + ARROZ + ".jpeg"));
    }

    @Test
    public void getDateSamplesCollected() { Date result = sample.getDateSamplesCollected(); }


    @Test
    public void getCode() {
        String result = sample.getCode();
        String expresult = "123456789101";
        assertEquals(result, expresult);
    }
    @Test
    public void setCode() {
        sample.setCode("arroz");
        String result = sample.getCode();
        String expresult = "arroz";
        assertEquals(expresult, result);
    }


    @Test
    public void testToString() { String result = sample.toString(); }


}