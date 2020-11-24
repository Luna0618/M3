package model;

import java.sql.Date;

public class LogInModel {
     private final String playerID;
     private final String username;
     private final Date log_in_date;

     public LogInModel(String playerID, String username, Date log_in_date){
         this.playerID = playerID;
         this.username = username;
         this.log_in_date = log_in_date;
     }

    public Date getLog_in_date() {
        return log_in_date;
    }

    public String getPlayerID() {
        return playerID;
    }

    public String getUsername() {
        return username;
    }
}
