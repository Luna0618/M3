package model;

import java.sql.Date;;

public class Gacha1Model {
    private final Date start_Date;
    private final Date end_date;

    public Gacha1Model(Date start_Date, Date end_date){
        this.start_Date = start_Date;
        this.end_date = end_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public Date getStart_Date() {
        return start_Date;
    }
}
