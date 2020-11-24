package model;

public class Pull2Model {
    private final String gacha_name;
    private final String c_name;
    private final String playerID;

    public Pull2Model(String gacha_name, String c_name, String playerID) {
        this.gacha_name = gacha_name;
        this.c_name = c_name;
        this.playerID = playerID;
    }

    public String getPlayerID() {
        return playerID;
    }

    public String getC_name() {
        return c_name;
    }

    public String getGacha_name() {
        return gacha_name;
    }
}
