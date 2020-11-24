package model;

import java.sql.Date;

public class PlayersJoinsModel {
    private final String playerID;
    private final String player_name;
    private final int rank;
    private final int currency;
    private final Date join_date;
    private final String clubID;

    public PlayersJoinsModel(String playerID, String player_name, int rank, int currency, Date join_date, String clubID) {
        this.clubID = clubID;
        this.currency = currency;
        this.join_date = join_date;
        this.player_name = player_name;
        this.playerID = playerID;
        this.rank = rank;
    }

    public String getPlayerID() {
        return playerID;
    }

    public Date getJoin_date() {
        return join_date;
    }

    public int getCurrency() {
        return currency;
    }

    public int getRank() {
        return rank;
    }

    public String getClubID() {
        return clubID;
    }

    public String getPlayer_name() {
        return player_name;
    }

}
