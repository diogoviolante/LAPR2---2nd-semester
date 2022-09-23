package app.domain.model;//package app.domain.model;

import app.domain.Store.AvailableTestStore;
import app.domain.Store.DiagnosisStore;
import app.domain.Store.TestStore;
import app.domain.model.Employee;
import app.domain.shared.ListofTests;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ValidationCoordinator extends AvailableTestStore {

    private TestStore test;
    ValidationCoordinator validationCoordinator;
    private Sample s;
    private Results r;
    private DiagnosisStore d;
    private List<Test> testList = new ArrayList<>();


    /**
     *
     * creates ValidationCoordinator
     */
    public ValidationCoordinator(TestStore test) {
        validateTest(test);
        this.test = test;
    }/**
     *
     * @return  test
     */

    public TestStore getTest() {
        return test;
    }
    /**
     *
     * method to validate the test
     */
    public void validateTest(TestStore test) {
        boolean checker = false;
        for (Test other : testList) {
            if (test.equals(other)) checker = true;
        }
        if (!checker) throw new IllegalArgumentException("Test is not available");
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!(other instanceof Employee))
            return false;
        ValidationCoordinator pc = (ValidationCoordinator) other;
        return /*Objects.equals(( r.getDate()),r.getDate()) &&*/ Objects.equals(s.getDateSamplesCollected(),s.getDateSamplesCollected()) && Objects.equals(d.getLongDate(),d.getLongDate());

    }
}