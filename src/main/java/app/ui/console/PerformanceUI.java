package app.ui.console;

import app.controller.PerformanceController;
import app.domain.Store.PerformanceStore;
import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class PerformanceUI implements Runnable {
    private Scanner ler= new Scanner(System.in);
    private PerformanceController controller= new PerformanceController();
    private int[] maxArray;


    @Override
    public void run() {
        boolean bol=false;
        do {
            System.out.println("Insert the start date");
            System.out.println("Start date: (year)");
            int birthYear = ler.nextInt();
            System.out.println("Start date: (month)");
            int birthMonth = ler.nextInt()-1;
            System.out.println("Start date: (day)");
            int birthDay = ler.nextInt();
            Calendar cal = Calendar.getInstance();
            cal.clear();
            cal.set(Calendar.YEAR, birthYear);
            cal.set(Calendar.MONTH, birthMonth);
            cal.set(Calendar.DAY_OF_MONTH, birthDay);
            Date startDate = cal.getTime();

            System.out.println("Insert the end date");
            System.out.println("End date: (year)");
            int birthYear1 = ler.nextInt();
            System.out.println("End date: (month)");
            int birthMonth1 = ler.nextInt()-1;
            System.out.println("End date: (day)");
            int birthDay1 = ler.nextInt();
            cal.clear();
            cal.set(Calendar.YEAR, birthYear1);
            cal.set(Calendar.MONTH, birthMonth1);
            cal.set(Calendar.DAY_OF_MONTH, birthDay1);
            Date endDate = cal.getTime();

            controller.getStatistics(startDate, endDate);
            boolean bol1=false;
            int option;

            do{
                System.out.println("Which algorithm do you wish to use?");
                System.out.println("1-Brute Force || 2-Other");
                option= ler.nextInt();

                if (option==1){
                    maxArray = controller.getSubarray(1,startDate, endDate);
                    System.out.println("R:"+Arrays.toString(maxArray));
                }else if (option==2){
                    StopWatch oleole=new StopWatch();
                    oleole.start();
                    maxArray= controller.getSubarray(2, startDate, endDate);
                    System.out.println("R:"+Arrays.toString(maxArray));
                    oleole.stop();
                    System.out.println(oleole.getNanoTime());
                }else System.out.println("Insert a valid option");
                System.out.println("Do you wish to use another algorithm?");
                System.out.println("1-Yes || 2-No");
                option=ler.nextInt();
                if (option==2){
                    bol1=true;
                }
            }while (!bol1);


            System.out.println("Do you wish to test other statistics?");
            System.out.println("1-Yes || 2-No");
            option=ler.nextInt();
            if (option==2){
                bol=true;
            }
        }while(!bol);

    }
}
