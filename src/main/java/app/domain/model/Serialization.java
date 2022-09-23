package app.domain.model;

import app.controller.App;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Serialization {
    private Company company = App.getInstance().getCompany();
    private List<TesteType> listTypes = company.getNewTestContainer();
    private List<ParameterCategory> categoryList = company.getParameterCategoryList();
    private List<Parameter> parameterList = company.getParametersList();
    private List<Client> clientList = company.getClientList();
    private List<Test> listOfTests = company.getTestList();
    private List<Sample> samplesList = company.getSampleList();
    private List<Results> resultsList = company.getResulList();
    private List<Diagnosis> diagnosisList = company.getDSList();
    private List<AllDates> datesList = company.getTestStore().getDates();
    ArrayList<TesteType> type = new ArrayList<>();
    ArrayList<ParameterCategory> category = new ArrayList<>();
    ArrayList<Parameter> parameter = new ArrayList<>();
    ArrayList<Client> client13 = new ArrayList<>();
    ArrayList<Test> tests = new ArrayList<>();
    ArrayList<Sample> samples = new ArrayList<>();
    ArrayList<Results> results = new ArrayList<>();
    ArrayList<Diagnosis> diagnosis = new ArrayList<>();
    ArrayList<AllDates> allDates = new ArrayList<>();

    public void serialize() throws IOException {


        FileOutputStream fileOut=new FileOutputStream("allData.dat");
        ObjectOutputStream outStream= new ObjectOutputStream(fileOut);
        try{
            type = new ArrayList<>(listTypes);
            outStream.writeObject(type);

            category = new ArrayList<>(categoryList);
            outStream.writeObject(category);

            parameter = new ArrayList<>(parameterList);
            outStream.writeObject(parameter);

            client13 = new ArrayList<>(clientList);
            outStream.writeObject(client13);

            tests = new ArrayList<>(listOfTests);
            outStream.writeObject(tests);

            samples = new ArrayList<>(samplesList);
            outStream.writeObject(samples);

            results = new ArrayList<>(resultsList);
            outStream.writeObject(results);

            diagnosis = new ArrayList<>(diagnosisList);
            outStream.writeObject(diagnosis);

            allDates = new ArrayList<>(datesList);
            outStream.writeObject(allDates);

        }catch (IOException i){
            i.printStackTrace();
        }finally {
            fileOut.close();
            outStream.close();
        }
    }
}
