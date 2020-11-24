package model;

public class FightsModel {
    private final String playerID;
    private final String team_name;
    private final String enemies_name;
    private final String result;

    public FightsModel(String name, String enemies_name, String result, String playerID){
        this.enemies_name = enemies_name;
        this.result = result;
        this.team_name = name;
        this.playerID = playerID;
    }

    public String getTeam_name() {
        return team_name;
    }

    public String getEnemies_name() {
        return enemies_name;
    }

    public String getPlayerID() {
        return playerID;
    }

    public String getResult() {
        return result;
    }
}
