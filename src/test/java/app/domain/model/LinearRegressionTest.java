package app.domain.model;


import app.controller.LinearRegression;
import org.junit.Test;


public class LinearRegressionTest {

    LinearRegression linearRegression = new LinearRegression(new double[]{10}, new double[]{10});
    LinearRegression linearRegression2 = new LinearRegression(new double[]{10}, new double[]{1});


    @Test
    public void intercept() { linearRegression.intercept(); }

    @Test
    public void slope() { linearRegression.slope(); }

    @Test
    public void r2() { linearRegression.R2(); }

    @Test
    public void interceptStdErr() { linearRegression.interceptStdErr(); }

    @Test
    public void slopeStdErr() { linearRegression.slopeStdErr(); }

    @Test
    public void predict() {
        double ar = 2;
        linearRegression.predict(ar);
    }

    @Test
    public void testToString() { String result = linearRegression.toString(); }
}