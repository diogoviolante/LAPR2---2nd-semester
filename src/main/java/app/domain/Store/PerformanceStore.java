package app.domain.Store;

import app.controller.App;
import app.domain.model.*;
import com.isep.mdis.Sum;
import com.nhs.report.Report2NHS;
import org.apache.commons.lang3.time.StopWatch;


import java.time.*;
import java.util.*;

public class PerformanceStore {
    private BruteForce bruteForce= new BruteForce();
    private Company company= App.getInstance().getCompany();
    private List<AllDates> list= company.getTestStore().getDates();
    private List<Test> testList = company.getTestList();
    private List<Client> clientList= company.getClientList();


    public int[] getTests(int option, Date start, Date end){

        int[] array = createArray(start, end);
        if (option==1){
            return bruteForce.maxSubArray(array);
        }else if (option==2){

           return Sum.Max(array);

        }
        return null;
    }

    public int[] dayByDay(LocalDate startDate, LocalDate endDate, int dif, String state){
        int i=0;

        int[] days = new int[dif+1];
        int count=0;

        for (LocalDate date = startDate; !startDate.isAfter(endDate); date = date.plusDays(1)){
            for (AllDates dates: list){
                LocalDate rightDate = dates.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                if (rightDate.equals(date)){
                    if (dates.getState().equals(state)){
                        count++;
                    }
                }
            }
            days[i] = count;
            i++;
        }

        System.out.println(state + ": " + Arrays.toString(days));
        return days;
    }
    public void getStatisticsDay(Date start, Date end){
        System.out.println("Statistics by day:\n");
        LocalDate startDate = start.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate endDate = end.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Period period = Period.between(startDate, endDate);
        int m= period.getMonths();
        int dif= period.getDays() + (m*30);

        List<int[]> day= new ArrayList<>();

        int count=0;

        for(Client client: clientList){
            count++;
        }

        System.out.println("Clients: " + count);

        day.add(dayByDay(startDate, endDate, dif, "Register"));
        day.add(dayByDay(startDate, endDate, dif, "Result"));
        day.add(dayByDay(startDate, endDate, dif, "Diagnosis"));
    }


    public void getStatisticsMonth(Date start, Date end){
        System.out.println("Statistics by Month:\n");
        LocalDate startDate = start.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate endDate = end.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int dif = endDate.getMonthValue()-startDate.getMonthValue();
        int monthStart = startDate.getMonthValue();
        int monthEnd = endDate.getMonthValue();

        List<int[]> day= new ArrayList<>();
        int i=0;

        int[] months = new int[dif];
        int count=0;
        for (LocalDate date = startDate; !startDate.isAfter(endDate); date = date.plusMonths(1)){
            for(Client client: clientList){
                count++;
            }
            months[i] = count;
            i++;
        }
        System.out.println("Clients: " + Arrays.toString(months));
        day.add(months);
        months = new int[dif];
        count=0;
        i=0;

        day.add(monthByMonth(startDate, endDate, dif, "Register"));
        day.add(monthByMonth(startDate, endDate, dif, "Result"));
        day.add(monthByMonth(startDate, endDate, dif, "Diagnosis"));
    }
    public int[] monthByMonth(LocalDate startDate, LocalDate endDate, int dif, String state){
        int i=0;

        int[] days = new int[dif];
        int count=0;

        for (int date = startDate.getMonthValue(); date<dif; date++ ){
            for (AllDates dates: list){
                LocalDate rightDate = dates.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                if (date==rightDate.getMonthValue()){
                    if (dates.getState().equals(state)){
                        count++;
                    }
                }
            }
            days[i] = count;
            i++;
        }

        System.out.println(state + ": " + Arrays.toString(days));
        return days;
    }


    public void getStatisticsYear(Date start, Date end){
        System.out.println("Statistics by Year:\n");
        LocalDate startDate = start.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate endDate = end.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int years = startDate.getYear();
        int years1 = endDate.getYear();
        int dif = years1-years;


        List<int[]> day= new ArrayList<>();


        int[] months = new int[dif];
        int count=0;
        for (AllDates dates: list){
            LocalDateTime rightDate = dates.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            for(Client client: clientList){
                count++;
            }
        }
        System.out.println("Clients: " + Arrays.toString(months));
        day.add(months);
        months = new int[dif];
        count=0;

        day.add(monthByMonth(startDate, endDate, dif, "Register"));
        day.add(monthByMonth(startDate, endDate, dif, "Result"));
        day.add(monthByMonth(startDate, endDate, dif, "Diagnosis"));
    }
    public int[] yearByYear(LocalDate startDate, LocalDate endDate, int dif, String state){
        int i=0;

        int[] days = new int[dif];
        int count=0;

        for (int date = startDate.getYear(); date<dif; date++){
            for (AllDates dates: list){
                LocalDate rightDate = dates.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                if (date==rightDate.getYear()){
                    if (dates.getState().equals(state)){
                        count++;
                    }
                }
            }
            days[i] = count;
            i++;
        }

        System.out.println(state + ": " + Arrays.toString(days));
        return days;
    }



    public void getStatistics(Date start, Date end){
        Calendar cal= Calendar.getInstance();
        cal.setTime(start);
        int years=cal.get(Calendar.YEAR);
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(end);
        int years1=cal1.get(Calendar.YEAR);
        int count =0;

        //getStatisticsDay(start, end);
        //System.out.println();
        //getStatisticsMonth(start, end);
        //System.out.println();
        //getStatisticsYear(start, end);
    }

    public int[] createArray(Date start, Date end){
        int[] arrayToAnalyse;
        LocalDate startDate = start.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate endDate = end.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        int[] hours = new int[]{8,9,10,11,12,13,14,15,16,17,18,19,20};
        int[] halfHour = new int[]{0,30};

        ArrayList<Integer> registers = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<AllDates> dates = new ArrayList<>();

        int registeredTests=0;
        int results = 0;

        for (LocalDate date=startDate; !date.isAfter(endDate); date =date.plusDays(1)){
            for (int i=0; i<hours.length-1; i++){
                for (AllDates date1: list) {
                    LocalDateTime rightDate = date1.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
                    if (date.getDayOfMonth() == rightDate.getDayOfMonth()) {
                        if (hours[i] <= rightDate.getHour() && hours[i + 1] > rightDate.getHour()) {
                            dates.add(date1);
                        }
                    }
                }
                for (AllDates date2: dates) {
                    LocalDateTime rightDate = date2.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
                    if (halfHour[0] < rightDate.getMinute() && halfHour[1] > rightDate.getMinute()) {

                        if (date2.getState().equals("Register")) {
                            registeredTests++;
                        } else if (date2.getState().equals("Result")) {
                            results++;
                        }
                    }
                }
                registers.add(registeredTests);
                result.add(results);
                registeredTests=0;
                results=0;
                for (AllDates date3: dates){
                    LocalDateTime rightDate = date3.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
                    if (halfHour[1] <= rightDate.getMinute()) {
                        if (date3.getState().equals("Register")) {
                            registeredTests++;
                        } else if (date3.getState().equals("Result")) {
                            results++;
                        }
                    }
                }
                dates = new ArrayList<>();
                registers.add(registeredTests);
                result.add(results);
                registeredTests = 0;
                results = 0;

                }
        }

        int[] registerArray = new int[registers.size()];
        int[] resultArray = new int[result.size()];

        for (int i=0; i< registers.size(); i++){
            registerArray[i]=registers.get(i);
        }

        for (int i=0; i< result.size(); i++){
            resultArray[i]=result.get(i);
        }

        if (registerArray.length>resultArray.length){
            arrayToAnalyse = new int[registerArray.length];
        }else arrayToAnalyse = new int[resultArray.length];

        for (int i=0; i< arrayToAnalyse.length; i++){
            arrayToAnalyse[i]=registerArray[i]-resultArray[i];
        }


        return arrayToAnalyse;
    }

}
