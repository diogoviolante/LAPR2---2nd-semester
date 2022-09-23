package app.controller;

import app.domain.model.Company;
import app.domain.model.Sample;
import app.domain.model.Test;
import app.domain.shared.ListofTests;
import java.util.ArrayList;
import java.util.List;

public class RegisterSampleController implements ListofTests {

    private List<Test> testList = new ArrayList<>();
    private List<Test> testWithoutSampleList = new ArrayList<>();
    private List<Sample> SampleList = new ArrayList<>();
    private Test code;


    /**
     * Initializes company
     */
    private Company company;


    /**
     * Initializes test
     */
    private Test test;


    /**
     * Initializes sample
     */
    private Sample sample;



    /**
     * Gets the company
     */
    public RegisterSampleController(){
        this(App.getInstance().getCompany());
    }



    /**
     * Synchronizes company
     * @param company company instance
     */
    public RegisterSampleController(Company company){
        this.company = company;
        this.test = null;
    }



    /**
     * List of test
     * @return list
     */
    public List<Test> getFullListOfTest(){ return this.company.getTestList(); }





    /**
     * Returns specific test
     * @param code code of test
     * @return test
     */
    public Test getTestByCode(String code){
        return this.company.getTestByCode(code);
    }



    /**
     * Creates sample
     * @return sample
     */
    public Sample createSample(String code) {
        try {
            return this.company.registSample(code);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    /**
     * Returns true if added
     * @param sample added
     * @return boolean result
     */
    public boolean saveSample(Sample sample){
        return this.company.saveSample(sample);
    }




    public void setTest(Test test) {
        this.test = test;
    }




}


