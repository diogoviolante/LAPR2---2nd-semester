package app.domain.model;

import java.io.Serializable;
import java.util.Date;

public class AllDates implements Serializable {
    private String code;



    private String state;

    private Date date;

    public AllDates(String code, Date date, String state) {
        setCode(code);
        setDate(date);
        setState(state);
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Code:" + code + "\nDate:" + date + "\n" + "\nState:" + state;
    }
}
