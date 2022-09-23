package app.domain.Store;

import org.junit.Test;

import java.util.Date;

public class PerformanceStoreTest {

    PerformanceStore performanceStore = new PerformanceStore();
    Date start = new Date("2021/5/10");
    Date end = new Date("2021/5/20");

    @Test
    public void getTests() { performanceStore.getTests(1, start, end ); }
    @Test
    public void getTests2() { performanceStore.getTests(2, start, end); }

    @Test
    public void getStatistics() { performanceStore.getStatistics(start, end); }

    @Test
    public void createArray() { performanceStore.createArray(start, end); }
}