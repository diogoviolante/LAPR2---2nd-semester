package app.domain.model;

import app.controller.App;
import app.domain.shared.Constants;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Deserialization {
    ArrayList<TesteType> type = new ArrayList<>();
    ArrayList<ParameterCategory> category = new ArrayList<>();
    ArrayList<Parameter> parameter = new ArrayList<>();
    ArrayList<Client> client13 = new ArrayList<>();
    ArrayList<Test> tests = new ArrayList<>();
    ArrayList<Sample> samples = new ArrayList<>();
    ArrayList<Results> results = new ArrayList<>();
    ArrayList<Diagnosis> diagnosis = new ArrayList<>();
    ArrayList<AllDates> allDates = new ArrayList<>();
    private Company company;
    private List<TesteType> listTypes ;
    private List<ParameterCategory> categoryList ;
    private List<Parameter> parameterList ;
    private List<Client> clientList ;
    private List<Test> listOfTests ;
    private List<Sample> samplesList ;
    private List<Results> resultsList ;
    private List<Diagnosis> diagnosisList ;
    private List<AllDates> datesList ;

    public Deserialization(){
        this.company=App.getInstance().getCompany();
        this.listTypes = company.getNewTestContainer();
        this.categoryList = company.getParameterCategoryList();
        this.parameterList = company.getParametersList();
        this.clientList = company.getClientList();
        this.listOfTests = company.getTestList();
        this.samplesList = company.getSampleList();
        this.resultsList = company.getResulList();
        this.diagnosisList = company.getDSList();
        this.datesList = company.getTestStore().getDates();
    }

    public void deserialization(){
        try{
            FileInputStream fileIn = new FileInputStream("allData.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);


            try{
                type = (ArrayList<TesteType>) in.readObject();
            }catch (ClassNotFoundException c){
                System.out.println("not found");
                c.printStackTrace(); return;
            }
            this.listTypes.addAll(type);

            try{
                category = (ArrayList<ParameterCategory>) in.readObject();
            }catch (ClassNotFoundException c){
                System.out.println("not found");
                c.printStackTrace(); return;
            }
            this.categoryList.addAll(category);

            try{
                parameter = (ArrayList<Parameter>) in.readObject();
            }catch (ClassNotFoundException c){
                System.out.println("not found");
                c.printStackTrace(); return;
            }
            this.parameterList.addAll(parameter);

            try{
                client13 = (ArrayList<Client>) in.readObject();
            }catch (ClassNotFoundException c){
                System.out.println("not found");
                c.printStackTrace(); return;
            }
            this.clientList.addAll(client13);

            try{
                tests = (ArrayList<Test>) in.readObject();
            }catch (ClassNotFoundException c){
                System.out.println("not found");
                c.printStackTrace(); return;
            }
            this.listOfTests.addAll(tests);

            try{
                samples = (ArrayList<Sample>) in.readObject();
            }catch (ClassNotFoundException c){
                System.out.println("not found");
                c.printStackTrace(); return;
            }
            //this.samplesList.addAll(samples);

            try{
                results = (ArrayList<Results>) in.readObject();
            }catch (ClassNotFoundException c){
                System.out.println("not found");
                c.printStackTrace(); return;
            }
            this.resultsList.addAll(results);

            try{
                diagnosis = (ArrayList<Diagnosis>) in.readObject();
            }catch (ClassNotFoundException c){
                System.out.println("not found");
                c.printStackTrace(); return;
            }
            this.diagnosisList.addAll(diagnosis);

            try{
                allDates = (ArrayList<AllDates>) in.readObject();
            }catch (ClassNotFoundException c){
                System.out.println("not found");
                c.printStackTrace(); return;
            }
            this.datesList.addAll(allDates);

            in.close();
            fileIn.close();

        }catch (IOException io){
            io.printStackTrace();
        }
    }
}
