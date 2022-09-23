package app.domain.model;

import app.controller.RegisterResultController;
import app.domain.Store.ClientStore;
import app.domain.Store.DiagnosisStore;
import app.domain.Store.ParameterStore;
import app.domain.Store.TestStore;
import app.domain.shared.Constants;
import app.domain.shared.ListOfClients;
import auth.domain.model.Email;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import static org.junit.Assert.assertEquals;


public class CVSfilesTest implements ListOfClients {


    CVSfiles cvsfiles = new CVSfiles();
    List<String> info =new ArrayList<>();
    List<Parameter> parameters = new ArrayList<>();
    List<ParameterCategory> parameterCategoryList = new ArrayList<>();
    DiagnosisStore dstore=new DiagnosisStore();
    TesteType newType = new TesteType("yauu", "yauuuuuu", "yaaaauuuuuuuuu", "12345", parameterCategoryList);
    String barcode = "000000000001";
    Client client = new Client("Rodrigo", "1234567891234567", 12345678911L, 1234567891L, 1234567891L, new Date("27/05/2002"), "Client", new Email("client@isep.pt"), "yauuuu");
    app.domain.model.Test test = new app.domain.model.Test(client, barcode, "123456789123", newType, parameters, "12345L", new Date("27/05/2002"));
    ClientStore clientStore = new ClientStore();
    TestStore testStore = new TestStore();
    ParameterStore parameterStore = new ParameterStore();
    RegisterResultController resultController = new RegisterResultController();
    Company company = new Company(Constants.PARAMS_COMPANY_DESIGNATION);
    int option1 = 1;
    int option2 = 2;
    int option3 = 3;






    @Test
    public void loadDataFileMATCPMDISC() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("ficheiros de import\\tests_BloodCovidMATCPMDISCCSV.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void loadDataFileMATCP() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("ficheiros de import\\tests_CovidMATCPCSV.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void loadDataFileMDISC() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("ficheiros de import\\tests_BloodMDISCCSV.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



    @Test
    public void choseOption() {
        try {
            cvsfiles.ChoseOption(option1);
            BufferedReader reader = cvsfiles.LoadDataFileMATCPMDISC();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            cvsfiles.ChoseOption(option2);
            BufferedReader reader = cvsfiles.LoadDataFileMATCP();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            cvsfiles.ChoseOption(option3);
            BufferedReader reader = cvsfiles.LoadDataFileMDISC();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



    @Test
    public void createNewClient1() throws IOException {
        cvsfiles.CreateNewClient(option1);
    }
    @Test
    public void createNewClient2() throws IOException {
        cvsfiles.CreateNewClient(option2);
    }
    @Test
    public void createNewClient3() throws IOException {
        cvsfiles.CreateNewClient(option3);
    }






}