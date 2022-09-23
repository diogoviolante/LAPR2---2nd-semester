package app.controller;

import app.domain.Store.ClientStore;
import app.domain.model.*;
import app.domain.shared.Constants;
import auth.AuthFacade;
import auth.UserSession;
import auth.domain.model.Email;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class App {

    private Company company;
    private AuthFacade authFacade;

    private App()
    {
        Properties props = getProperties();
        this.company = new Company(props.getProperty(Constants.PARAMS_COMPANY_DESIGNATION));
        this.authFacade = this.company.getAuthFacade();
        bootstrap();
    }

    public Company getCompany()
    {
        return this.company;
    }

    public UserSession getCurrentUserSession()
    {
        return this.authFacade.getCurrentUserSession();
    }

    public boolean doLogin(String email, String pwd)
    {
        return this.authFacade.doLogin(email,pwd).isLoggedIn();
    }

    public void doLogout()
    {
        this.authFacade.doLogout();
    }

    private Properties getProperties()
    {
        Properties props = new Properties();

        // Add default properties and values
        props.setProperty(Constants.PARAMS_COMPANY_DESIGNATION, "Many Labs");


        // Read configured values
        try
        {
            InputStream in = new FileInputStream(Constants.PARAMS_FILENAME);
            props.load(in);
            in.close();
        }
        catch(IOException ex)
        {

        }
        return props;
    }


    private void bootstrap()
    {
        this.authFacade.addUserRole(Constants.ROLE_ADMIN,Constants.ROLE_ADMIN);
        this.authFacade.addUserWithRole("carrusca", "123@isep.pt", "123456",Constants.ROLE_ADMIN);
        this.authFacade.addUserWithRole("pedro", "123@isep.pt", "123456",Constants.ROLE_ADMIN);
        this.authFacade.addUserWithRole("joao", "123@isep.pt", "123456",Constants.ROLE_ADMIN);

        this.authFacade.addUserRole(Constants.ROLE_LAB_TECHNICIAN, Constants.ROLE_LAB_TECHNICIAN);
        this.authFacade.addUserWithRole("SOUSA", "12345@isep.ipp.pt", "1234567", Constants.ROLE_LAB_TECHNICIAN);

        this.authFacade.addUserRole(Constants.ROLE_CLINICAL_CHEMISTRY_TECHNOLOGIST, Constants.ROLE_CLINICAL_CHEMISTRY_TECHNOLOGIST);
        this.authFacade.addUserWithRole("dfsdfds" , "12345@isep.pt", "1234567", Constants.ROLE_CLINICAL_CHEMISTRY_TECHNOLOGIST);

        this.authFacade.addUserRole(Constants.ROLE_RECEPTIONIST, Constants.ROLE_RECEPTIONIST);
        this.authFacade.addUserWithRole("violas", "1234@isep.ipp.pt", "1234567", Constants.ROLE_RECEPTIONIST);

        this.authFacade.addUserRole(Constants.ROLE_CLIENT, Constants.ROLE_CLIENT);
        this.authFacade.addUserWithRole("diogo", "client@isep.pt", "1234567", Constants.ROLE_CLIENT);

        this.authFacade.addUserRole(Constants.ROLE_SPECIALIST_DOCTOR,Constants.ROLE_SPECIALIST_DOCTOR);
        this.authFacade.addUserWithRole("Joao","199@isep.pt","98765",Constants.ROLE_SPECIALIST_DOCTOR);

        this.authFacade.addUserRole(Constants.ROLE_LABORATORY_COORDINATOR, Constants.ROLE_LABORATORY_COORDINATOR);
        this.authFacade.addUserWithRole("rei","1@isep.pt","12345",Constants.ROLE_LABORATORY_COORDINATOR);

        /*ParameterCategory pc1= new ParameterCategory("12345","Covid");
        ParameterCategory pc2 = new ParameterCategory("98765","Hemogram");
        List<ParameterCategory> categoryList = this.company.getParameterCategoryList();
        categoryList.add(pc1);
        categoryList.add(pc2);

        List<ParameterCategory> lista= new ArrayList<>();
        ClientStore store = new ClientStore();
        lista.add(new ParameterCategory("12348","Hemogram"));

        TesteType tt= new TesteType("Blood","blood","swab","12345",lista);

        lista = new ArrayList<>();
        lista.add(new ParameterCategory("12345","Covid"));
        TesteType tt1= new TesteType("Covid","blood","swab","54321",lista);

        Client client= new Client("Rodrigo","1234567891234567",12345678911L,1234567891L,1234567891L,new Date("27/05/2002"),"Client", new Email("cliente1@isep.pt"),"yauuuu");
        store.saveClient(client);

        List<TesteType> listTypes = this.company.getNewTestContainer();
        listTypes.add(tt);
        listTypes.add(tt1);

         */





    }

    // Extracted from https://www.javaworld.com/article/2073352/core-java/core-java-simply-singleton.html?page=2
    private static App singleton = null;
    public static App getInstance()
    {
        if(singleton == null)
        {
            synchronized(App.class)
            {
                singleton = new App();
            }
        }
        return singleton;
    }
}
