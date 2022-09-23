package app.domain.model;


import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

import java.io.Serializable;

public class Results implements Serializable {


    /**
     * TestType of the results
     */
    private String testType;
    /**
     * Parameter of the result
     */
    private String parameter;

    /**
     * Metric of the Results
     */
    private String metric;
    /**
     * Min Value of the result
     */
    private double minValue;
    /**
     * Max Value of the result
     */
    private double maxValue;

    /**
     * Result of the test
     */
    private String result;

    /**
     * code of the test
     */
    private String code;



    private double value;


    /**
     * Results Constructor
     *
     * @param testeType test type
     * @param parameter analysed parameter
     * @param code code of the test
     */
    public Results(String testeType, String parameter, String code, String result, double value) {
        setTestType(testeType);
        setParameter(parameter);
        setCode(code);
        setResult(result);
        setValue(value);
    }


    public double getValue() { return value; }

    public void setValue(double value) { this.value = value; }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) { this.testType = testType; }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String isResult() {
        return result;
    }

    public void setResult(String result) { this.result = result; }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
     public String toString() {
        return "Test type: " + testType + "\nParameter: " + parameter + "\nCode: " + code + "\nResult: " + result+ "\nValue: " + value;
    }
}
