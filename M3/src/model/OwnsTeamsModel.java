package model;

public class OwnsTeamsModel {
    private final String playerID;
    private final String t_leader;
    private final int team_AP;
    private final String team_name;

    public OwnsTeamsModel(String playerID, String t_leader, int team_AP, String team_name){
        this.playerID = playerID;
        this.t_leader = t_leader;
        this. team_AP = team_AP;
        this. team_name = team_name;
    }

    public String getPlayerID() {
        return playerID;
    }

    public String getTeam_name() {
        return team_name;
    }

    public int getTeam_AP() {
        return team_AP;
    }

    public String getT_leader() {
        return t_leader;
    }
}
