package app.domain.Store;
import app.controller.App;
import app.domain.model.*;
import app.domain.shared.*;
import com.example1.ExternalModule3API;
import com.example3.CovidReferenceValues1API;

import java.io.*;
import java.util.*;

public class HistoryStore implements PastTests, ListOfClients, ListOfResults, ListaCategorias, ListofTests {
    private Scanner ler = new Scanner(System.in);
    private Client client;
    private InputStream input;
    private Company company = App.getInstance().getCompany();
    private Long tinNumber;
    private String code;
    private Results results;
    private Long lim1 = 1000000000L;
    private Long lim2 = 9999999999L;
    private int count = 0;
    private int count1 = 0;

    public Algoritmo1 checkAlgorithm1() {
        File configFile = new File("config.properties");
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(configFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String key = properties.getProperty("algoritmo1");
        if (key==null){
            return null;
        }else {
            Class< ? > class1 = null;

            try {
                class1 = Class.forName(key);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            Algoritmo1 algoritmo1 = null;

            try {
                algoritmo1 = (Algoritmo1) class1.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
            return algoritmo1;
        }
    }


    public void getAlgoritmo1() throws IOException {
        Algoritmo1 algoritmo = checkAlgorithm1();
        System.out.println("1-Order by Tax Number");
        System.out.println("2-Order by Name");
        int index =ler.nextInt();

        if (index==1){
            algoritmo.showTinList(clientList);
        }else if (index==2){
            algoritmo.showNameList(clientList);
        }else {
            System.out.println("Insert a valid answer.");
        }
    }


    public Algoritmo2 checkAlgorithm2() {
        File configFile = new File("config.properties");
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(configFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String key = properties.getProperty("algoritmo2");

        if (key==null){
            return null;
        }else {
            Class< ? > class2 = null;
            try {
                class2 = Class.forName(key);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            Algoritmo2 algoritmo2 = null;
            try {
                algoritmo2 = (Algoritmo2) class2.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
            return algoritmo2;
        }

    }

    public void getAlgoritmo2() throws IOException {
        Algoritmo2 algoritmo = checkAlgorithm2();
        System.out.println("1-Order by Tax Number");
        System.out.println("2-Order by Name");
        int index =ler.nextInt();

        if (index==1){
            algoritmo.showTINList1(clientList);
        }else if (index==2){
            algoritmo.showNameList1(clientList);
        }else {
            System.out.println("Insert a valid answer.");
        }

    }

    public void chooseTest() {
        do {
            System.out.println("Insert Tax Number(10 digits):");
            tinNumber = ler.nextLong();
        } while (tinNumber < lim1 || tinNumber > lim2);

        for (Client list : clientList) {
            if (tinNumber.equals(list.getTaxNumber())) {
                count++;
                for (Test yau : pastTests) {
                    if (yau.getClient().equals(list)) {
                        System.out.println(yau.toString());
                    }
                }
            }
        }
        if (count == 0) {
            System.out.println("There's no client with the inserted Tax Number!");
        } else {
            System.out.println("What test you want to consult?(insert test code)");
            code = ler.next();
            for (Results details : resultsList) {
                if (details.getCode().equals(code)) {
                    count1++;
                    System.out.println();
                    System.out.println("\n" + details.toString());
                    ExternalModule3API blood = new ExternalModule3API();

                    if (details.getParameter().equals("IgGAN")) {
                        CovidReferenceValues1API covid = new CovidReferenceValues1API();
                        System.out.println();
                        System.out.printf("Minimum value(IgGAN)=%s \nMaximum Value(IgGAN)=%s", covid.getMinReferenceValue("IgGAN", 12345), covid.getMaxReferenceValue("IgGAN", 12345));
                    } else if (details.getParameter().equals("ESR00")) {
                        System.out.printf("Minimum Value(ESR00)=%s \nMaximum Value(ESR00)=%s", blood.getMinReferenceValue("ESR00", 12345), blood.getMaxReferenceValue("ESR00", 12345));
                    } else if (details.getParameter().equals("HB000")) {
                        System.out.printf("Minimum Value(HB000)=%s \nMaximum Value(HB000)=%s", blood.getMinReferenceValue("HB000", 12345), blood.getMaxReferenceValue("HB000", 12345));
                    } else if (details.getParameter().equals("MCH00")) {
                        System.out.printf("Minimum Value(MCH00)=%s \nMaximum Value(MCH00)=%s", blood.getMinReferenceValue("MCH00", 12345), blood.getMaxReferenceValue("MCH00", 12345));
                    } else if (details.getParameter().equals("MCHC0")) {
                        System.out.printf("Minimum Value(MCHC0)=%s \nMaximum Value(MCHC0)=%s", blood.getMinReferenceValue("MCHC0", 12345), blood.getMaxReferenceValue("MCHC0", 12345));
                    } else if (details.getParameter().equals("MCV00")) {
                        System.out.printf("Minimum Value(MCV00)=%s \nMaximum Value(MCV00)=%s", blood.getMinReferenceValue("MCV00", 12345), blood.getMaxReferenceValue("MCV00", 12345));
                    } else if (details.getParameter().equals("PLT00")) {
                        System.out.printf("Minimum Value(PLT00)=%s \nMaximum Value(PLT00)=%s", blood.getMinReferenceValue("PLT00", 12345), blood.getMaxReferenceValue("PLT00", 12345));
                    } else if (details.getParameter().equals("RBC00")) {
                        System.out.printf("Minimum Value(RBC00)=%s \nMaximum Value(RBC00)=%s", blood.getMinReferenceValue("RBC00", 12345), blood.getMaxReferenceValue("RBC00", 12345));
                    } else if (details.getParameter().equals("WBC00")) {
                        System.out.printf("Minimum Value(WBC00)=%s \nMaximum Value(WBC00)=%s", blood.getMinReferenceValue("WBC00", 12345), blood.getMaxReferenceValue("WBC00", 12345));
                    }
                }
            }
        }
    }
}
