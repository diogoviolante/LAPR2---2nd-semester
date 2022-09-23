package app.domain.model;

/**************************
 *  Compute least squares solution to y = beta * x + alpha.
 *  Simple linear regression.
 **************************/

import com.nhs.report.Report2NHS;
import org.apache.commons.math3.distribution.FDistribution;
import org.apache.commons.math3.distribution.TDistribution;

import java.sql.Date;
import java.time.Instant;

/**
 *  The code LinearRegression class performs a simple linear regression
 *  on an set of n data points (y_i, x_i).
 *  That is, it fits a straight line y = alpha + beta * x,
 *  (where y is the response variable, x is the predictor variable,
 *  alpha is the y-intercept, and beta is the slope)
 *  that minimizes the sum of squared residuals of the linear regression model.
 *  It also computes associated statistics, including the coefficient of
 *  determination R^2 and the standard deviation of the
 *  estimates for the slope and y-intercept.
 *
 */
public class LinearRegression2 {
    private final double intercept, slope;
    private final double r2;
    private final double svar0, svar1;

    /**
     * Performs a linear regression on the data points (y[i], x[i]).
     *
     * @param  x the values of the predictor variable
     * @param  y the corresponding values of the response variable
     * @throws IllegalArgumentException if the lengths of the two arrays are not equal
     */
    public LinearRegression2(double[] x, double[] y, double significance,String[] date,double[] aTotal,double[] aPositive,String[] aDate) {
        if (x.length != y.length) {
            throw new IllegalArgumentException("array lengths are not equal");
        }
        int n = x.length;

        // first pass
        double sumx = 0.0, sumy = 0.0, sumx2 = 0.0;
        for (int i = 0; i < n; i++) {
            sumx  += x[i];
            sumx2 += x[i]*x[i];//media x^2
            sumy  += y[i];
        }
        double xbar = sumx / n;//media x
        double ybar = sumy / n;//media y

        // second pass: compute summary statistics
        double xxbar = 0.0, yybar = 0.0, xybar = 0.0;
        for (int i = 0; i < n; i++) {
            xxbar += (x[i] - xbar) * (x[i] - xbar);
            yybar += (y[i] - ybar) * (y[i] - ybar);
            xybar += (x[i] - xbar) * (y[i] - ybar);
        }
        slope  = xybar / xxbar;//b^
        intercept = ybar - slope * xbar;//ordenada na origem, a^
        double raiz =Math.sqrt((1/n) + (Math.pow(sumx,2)/sumx2));
        double R = xybar/(Math.sqrt(xxbar)*Math.sqrt(yybar));

        // more statistical analysis
        double rss = 0.0;      // residual sum of squares
        double ssr = 0.0;      // regression sum of squares
        for (int i = 0; i < n; i++) {
            double fit = slope*x[i] + intercept;
            rss += (fit - y[i]) * (fit - y[i]);
            ssr += (fit - ybar) * (fit - ybar);
        }

        int degreesOfFreedom = n-2;
        r2    = ssr / yybar;//R2
        double svar  = rss / degreesOfFreedom;
        svar1 = svar / xxbar;
        svar0 = svar/n + xbar*xbar*svar1;

//        System.out.println(xbar + " " + ybar +"\n" + ssr +" "+ rss + "\n" +degreesOfFreedom +" "+ssr + " " + rss /degreesOfFreedom);
        double s =Math.sqrt(xxbar/(n-1));
        // Table number 7 from MATCP - t-Student
        TDistribution td= new TDistribution(degreesOfFreedom);
        double critTD=0.0;
        if(significance > 0.5) {
            critTD = td.inverseCumulativeProbability(significance);
        }
        else {
            critTD = td.inverseCumulativeProbability(1 - significance);
        }
        double triangle = critTD*s*Math.sqrt((1/n) +raiz);


        FDistribution fd= new FDistribution(1,degreesOfFreedom);
        double critFD= fd.inverseCumulativeProbability(1- significance);

        if(aDate[0]==null){
            Report2NHS.writeUsingFileWriter(MakeCovidReport(R,triangle,y,x, s,n,ssr,degreesOfFreedom,rss,significance,critFD,critTD, xxbar, date));
        }else{
            Report2NHS.writeUsingFileWriter(MakeCovidReport(R,triangle,aPositive,aTotal, s,aTotal.length,ssr,degreesOfFreedom,rss,significance,critFD,critTD, xxbar, aDate));
        }

        System.out.println("Report sent!" + Date.from(Instant.now()));

    }

    public String MakeCovidReport(double R, double triangle, double[] y, double[] x, double S, int n, double ssr, int degreesOfFreedom, double rss, double significance, double critFD, double critTD, double xxbar, String[] date){
        double[] IC1 = new double[n];
        double[] IC2 = new double[n];

        double tb=(slope()/slopeStdErr());
        double ta=(intercept()/interceptStdErr());
        for(int i = 0 ; i<=n-1;i++){
            IC1[i] = (slope()*x[i] + intercept())-triangle;
            IC2[i] = (slope()*x[i] + intercept())+triangle;
        }





        StringBuilder s = new StringBuilder();
        s.append(String.format(("The regression model fitted using data from the interval %ny = %.2f x + %.2f"),slope(),intercept()));
        s.append(String.format(("%n%nOther statistics%nR = %.3f %nR^2 = %.3f %nR^2adjusted = %.3f"),R,R2(),R2()));
        s.append(String.format(("%n%nHypothesis tests for regression coefficients%nHO:b=0 (a=0) H1: b<>0 (a<>0)%nt_obs = %.3f"),critTD));
        if((tb > critTD || ta > critTD)){
            s.append(String.format("%nDecision: |t|%nta  %.2f > %.2f",tb,critTD));
            s.append(String.format("%nReject H0 %nThe test is conclusive"));
        }else{
            s.append(String.format("%nDecision: |t|%nta  %.2f <= %.2f",tb,critTD));
            s.append(String.format("%nNo reject H0 %nThe test is inconclusive"));
        }
        s.append(String.format("%n%nSignificance model with Anova%nH0: b=0 H1 b<>0%n"));
        s.append(String.format("               df         SS        MS            F%n" ));
        s.append(String.format("Regression:    %d        %.3f      %.3f     %.3f%n",1 ,ssr, ssr,ssr/(rss/degreesOfFreedom)));
        s.append(String.format("Residual:      %d        %.3f       %.3f      %n",degreesOfFreedom ,rss,rss/degreesOfFreedom));
        s.append(String.format("Total:         %d       %.3f         %n%n",degreesOfFreedom+1 ,ssr+rss));
        if((ssr/(rss/degreesOfFreedom) > critFD)){
            s.append(String.format("Decision: f%n %.2f > f%.2f,(%o.%o)=%.3f",ssr/(rss/degreesOfFreedom),significance,1,degreesOfFreedom,critFD));
            s.append(String.format("%nReject H0%nThe regression model is significant."));
        }else{
            s.append(String.format("Decision: f%n %.2f <= f%.2f,(%o.%o)=%.3f",ssr/(rss/degreesOfFreedom),significance,1,degreesOfFreedom,critFD));
            s.append(String.format("%nNo reject H0%nThe regression model is not significant."));
        }
        s.append(String.format("%n %nPrediction values%n %nDate           Number of OBSERVED positive cases        Number of ESTIMATED/EXPECTED positive cases          %.0f%%  intervals",(1-significance)*100));
        for(int i =0;i<=n-1;i++){
            s.append(String.format("%n%s                    %.0f                                      %.2f                                     %.2f-%.2f", date[(n-1)-i].trim(),y[(n-1)-i],(x[(n-1)-i]*slope())+intercept(),IC1[(n-1)-i],IC2[(n-1)-i]));
        }
        return s.toString();


    }


    /**
     * Returns the y-intercept alpha of the best of the best-fit line y = alpha + beta * x.
     *
     * @return the y-intercept alpha of the best-fit line y = alpha + beta * x
     */
    public double intercept() {
        return intercept;
    }

    /**
     * Returns the slope beta of the best of the best-fit line y = alpha + beta * x.
     *
     * @return the slope beta of the best-fit line y = alpha + beta * x
     */
    public double slope() {
        return slope;
    }

    /**
     * Returns the coefficient of determination R^2.
     *
     * @return the coefficient of determination R^2,
     *         which is a real number between 0 and 1
     */
    public double R2() {
        return r2;
    }

    /**
     * Returns the standard error of the estimate for the intercept.
     *
     * @return the standard error of the estimate for the intercept
     */
    public double interceptStdErr() {
        return Math.sqrt(svar0);
    }

    /**
     * Returns the standard error of the estimate for the slope.
     *
     * @return the standard error of the estimate for the slope
     */
    public double slopeStdErr() {
        return Math.sqrt(svar1);
    }

    /**
     * Returns the expected response y given the value of the predictor
     * variable x.
     *
     * @param  x the value of the predictor variable
     * @return the expected response y given the value of the predictor
     *         variable x
     */
    public double predict(double x) {
        return slope*x + intercept;
    }

    /**
     * Returns a string representation of the simple linear regression model.
     *
     * @return a string representation of the simple linear regression model,
     *         including the best-fit line and the coefficient of determination
     *         R^2
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(String.format("%.2f n + %.2f", slope(), intercept()));
        s.append("  (R^2 = " + String.format("%.3f", R2()) + ")");
        return s.toString();
    }

}