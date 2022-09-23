package app.controller;

import app.domain.model.Company;
import app.domain.model.Results;
import app.domain.model.Test;
import app.domain.model.TesteType;
import app.domain.shared.ListDates;

import java.util.Date;
import java.util.List;

public class RegisterResultController implements ListDates {

    /**
     * Initializes Company
     */
    private Company company=App.getInstance().getCompany();



    public List<Test> getTestTypeList() {
        return this.company.getTestList();
    }

    public TesteType getTestType(String barcodeString) {
        return this.company.getTestType(barcodeString);
    }



    public Test getTest(String barcodeString) {
        return this.company.getTestWithBarcode(barcodeString);
    }

    public boolean validateBarcodeString(String barcodeString) {
        return this.company.validateBarcodeString(barcodeString);
    }

    public String bloodAPI3(double valueParameter, String parameters, int accessKey) {
        return this.company.bloodAPI3(valueParameter, parameters, accessKey);
    }

    public String bloodAPI31(double valueParameter, String parameters, int accessKey) {
        return this.company.bloodAPI31(valueParameter, parameters, accessKey);
    }

    public String covidAPI1(double valueParameter, int accessKey, String igGAN) {
        return this.company.covidAPI1(valueParameter, accessKey, igGAN);
    }

    public String covidAPI11(double valueParameter, int accessKey, String igGAN) {
        return this.company.covidAPI11(valueParameter, accessKey, igGAN);
    }


    public Results createResult(String testeType, String parameter, String code, String result, double value) {
        return new Results(testeType, parameter, code, result, value);
    }


    public void setDateResultToTest(Test t) {
        this.company.addToList(t);
    }



    public Date setDate(Date date) {
        return date;
    }

}
