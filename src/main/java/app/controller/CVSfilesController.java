package app.controller;

import app.domain.model.CVSfiles;
import app.domain.model.Company;
import app.domain.model.Test;
import app.domain.shared.ListOfTypes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class CVSfilesController  {
private Company company;
private CVSfiles files;
    public CVSfilesController(){
    this(App.getInstance().getCompany());
}


    public CVSfilesController(Company company) {
   this.files=new CVSfiles();
        this.company=company;
    }

public void choseOption(int option) throws FileNotFoundException {
    this.files.ChoseOption(option);
}



    public void AddTest(int option){
        this.files.AddTest(option);
    }


}
