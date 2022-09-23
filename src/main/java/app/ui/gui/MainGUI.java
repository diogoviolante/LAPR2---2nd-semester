package app.ui.gui;


import app.domain.Store.ClientStore;
import app.domain.Store.TestStore;
import app.domain.model.*;
import app.domain.shared.*;
import auth.domain.model.Email;
import app.ui.console.AutomaticReportUI;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;


public class MainGUI extends Application implements ListOfClients, ListofTests, ListOfTypes, ListDates, ListOfResults, ListOfDiagnosis, ListOfParameters, ListaCategorias, ListOfSamples, PastTests {
    /*public static void main(String[] args) {
        List<ParameterCategory> lista= new ArrayList<>();
        List<Parameter> param= new ArrayList<>();
        TestStore testStore= new TestStore();
        ClientStore store = new ClientStore();

        lista.add(new ParameterCategory("12348","Hemogram"));
        param.add(new Parameter("12377","ESR00","cenas","Hemogram"));
        param.add(new Parameter("12378","MCH00","asdsa","Hemogram"));
        param.add(new Parameter("12379","MCHC0","adadadd","Hemogram"));
        param.add(new Parameter("12380","MCV00","dvvsvs","Hemogram"));
        param.add(new Parameter("12381","PLT00","vefefef", "Hemogram"));
        param.add(new Parameter("12382","RBC00", "frbrrbr", "Hemogram"));
        param.add(new Parameter("12383","WBC00", "aasdasda","Hemogram"));
        TesteType tt= new TesteType("Blood","blood","swab","12345",lista);



        Client client= new Client("Rodrigo","1234567891234567",12345678911L,1234567891L,1234567891L,new Date("27/05/2002"),"Client", new Email("cliente1@isep.pt"),"yauuuu");
        store.saveClient(client);
        Test test= new Test(client,"000000000001", "123456789111", tt, param, "12425", new Date());
        lista = new ArrayList<>();
        param = new ArrayList<>();
        lista.add(new ParameterCategory("12345","Covid"));
        param.add(new Parameter("12344","b89","swab for covid19","Covid"));
        TesteType tt1= new TesteType("Covid","blood","swab","54321",lista);



        lista.add(new ParameterCategory("12345","blood"));
        param.add(new Parameter("12344","b89","bloddee","blood"));





        ParameterCategory pc1= new ParameterCategory("12345","Covid");
        ParameterCategory pc2 = new ParameterCategory("98765","Hemogram");
        ParameterCategory pc3= new ParameterCategory("87323","Cholesterol");
        listacategorias.add(pc1);
        listacategorias.add(pc2);

        Client client2= new Client("Yau","1234567891234568",12345678912L,1234567891L,1234567892L,new Date("23/02/1997"),"Client", new Email("123@yauyau.com"),"yauuuu");
        clientList.add(client2);
        Client client3= new Client("Andre","1234567891234566",12345678922L,1234567852L,1234569871L,new Date("23/12/2002"),"yau",new Email("asdasda@zxcs.com"),"asdasdasdas");
        clientList.add(client3);

        Test test1= new Test(client,"000000000002", "123456789112", tt1, param, "12425", new Date());
        Test test2= new Test(client,"000000000003", "123456789113", tt1, param, "12425", new Date());
        pastTests.add(test);
        pastTests.add(test1);
        pastTests.add(test2);




        //testStore.saveTest(test);

        listTypes.add(tt);
        listTypes.add(tt1);
    }

     */

    @Override
    public void start(Stage stage) throws Exception {

        Timer t = new Timer();
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 6);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        TimerTask auto = new AutomaticReportUI();
        t.schedule(auto, today.getTime(), TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS));



        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/InitialScene.fxml"));
            Parent root= loader.load();
            stage.initStyle(StageStyle.TRANSPARENT);
            Scene scene = new Scene(root);

            stage.setTitle("Many Labs");
            stage.getIcons().add((new Image("/fxml/ImageOne.jpeg")));
            stage.setResizable(false);
            stage.setScene(scene);

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
