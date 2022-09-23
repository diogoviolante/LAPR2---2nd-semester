package app.controller;

import app.domain.Store.ClientStore;
import app.domain.model.Client;
import app.domain.model.Company;
import app.domain.shared.Constants;
import auth.AuthFacade;
import auth.UserSession;
import auth.domain.model.Email;
import java.io.IOException;
import java.util.Date;

public class CreateClientController {

    private final ClientStore store = new ClientStore();
    private Company company;
    private Client client;
    private final AuthFacade authFacade = new AuthFacade();

    public CreateClientController() {
        this.company = App.getInstance().getCompany();
    }

    public CreateClientController(Company company) {
        this.company = company;
        this.client = null;

    }


    public Client createClient(String name, String citizenNumber, long phoneNumber,  long nhsNumber, long taxNumber, Date birthDate, Email email, String adress) {
        UserSession userSession = authFacade.getCurrentUserSession();

        return this.client = this.store.createClient(name, citizenNumber, phoneNumber, nhsNumber, taxNumber, birthDate,  email, adress);
    }

    public Client createClientWithGender(String name, String citizenNumber, long phoneNumber,  long nhsNumber, long taxNumber, Date birthDate, String gender, Email email, String adress) throws IOException {
        UserSession userSession= authFacade.getCurrentUserSession();

        return this.client = this.store.createClientWithGender(name, citizenNumber, phoneNumber, nhsNumber, taxNumber, birthDate,  gender, email,adress);
    }

    public void saveClient (Client client) {
        this.store.saveClient(client);
    }
}