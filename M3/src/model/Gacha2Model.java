package model;

import java.sql.Date;

public class Gacha2Model {
    private final String gacha_name;
    private final Date start_date;

    public Gacha2Model(String gacha_name, Date start_date){
        this.gacha_name = gacha_name;
        this.start_date = start_date;
    }

    public String getGacha_name() {
        return gacha_name;
    }

    public Date getStart_date() {
        return start_date;
    }
}
