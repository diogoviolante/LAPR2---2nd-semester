package app.controller;

import app.domain.Store.PerformanceStore;

import java.util.Date;
import java.util.List;

public class PerformanceController {
    private PerformanceStore store = new PerformanceStore();

    public void getStatistics(Date start, Date end){
        store.getStatistics(start, end);
    }

    public int[] getSubarray(int option, Date start, Date end){
        return store.getTests(option, start, end);
    }
}
