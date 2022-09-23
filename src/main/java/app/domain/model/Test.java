package app.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test implements Serializable {

    /**
     * code of the test.
     */
    private String code;
    /**
     * NHS code to identify the test.
     */
    private String nhsCode;
    /**
     * information of the client.
     */
    private Client client;
    /**
     * type of test.
     */
    private TesteType type;
    /**
     * ArrayList of categories to be analysed. pode remover
     */
    private List<ParameterCategory> categories = new ArrayList<>();
    /**
     * ArrayList of parameters to be analysed.
     */
    private List<Parameter> parameters = new ArrayList<>();

    /**
     * Id of the laboratory to be associated with the test.
     */
    private String labId;

    /**
     * date of test registration.
     */
    private Date date;

    /**
     * Test constructor.
     * @param client information of the client.
     * @param code code of the test.
     * @param nhsCode NHS code to identify the test.
     * @param type type of test.
     * @param parameters ArrayList of parameters to be analysed.
     *
     */
    public Test (Client client, String code, String nhsCode, TesteType type, List<Parameter> parameters, String labId, Date date) {

        validateNHSCode(String.valueOf(nhsCode));
        validateClient(client);

        this.client = client;
        this.nhsCode = nhsCode;
        this.code = code;
        this.type = type;
        this.parameters = parameters;
        this.labId = labId;
        this.date = date;
    }

    //tentar implementar classe Parametros e associar ao teste.

    /**
     * method to get the client's information.
     * @return client's information.
     */
    public Client getClient() {return client;}

    /**
     * method to get the type of test.
     * @return type of test.
     */
    public TesteType getType() { return type; }

    /**
     * method to get the list of parameters to be analysed in a test.
     * @return list of parameters to be analysed in a test.
     */
    public List<Parameter> getParameters() { return parameters; }

    /**
     * method to get the NHS code of a registered test.
     * @return NHS code of a registered test.
     */
    public String getNhsCode () {
        return nhsCode;
    }

    /**
     * method to get the code of a registered test.
     * @return code of a registered test.
     */
    public String getCode() {return code;}

    /**
     * method to get the laboratory ID.
     * @return laboratory ID
     */
    public String getLabId() {
        return labId;
    }

    /**
     * method to get the date of registration.
     * @return date of registration
     */
    public Date getDate() {
        return date;
    }

    /**
     * method to validate the NHS code.
     * @param nhsCode NHS code of a test.
     */

    public void validateNHSCode (String nhsCode) {
        if (nhsCode.length() != 12) {
            throw new IllegalArgumentException("Introduce a valid NHS Code.");
        }
    }

    /**
     * method to validate the client.
     * @param client client.
     */
    public void validateClient(Client client) {
        if (client == null) {
            throw new IllegalArgumentException("Client is null.");
        }
    }

    @Override
    public String toString() {
        return "Code:" + code + "   NHS number:" + nhsCode + "   Time:" + date;
    }

}
