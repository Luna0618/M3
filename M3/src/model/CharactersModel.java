package model;

public class CharactersModel {
    public final String c_name;
    public final String c_rarity;
    public final String skill;
    public final int AP;

    public CharactersModel(String c_name, String c_rarity, String skill, int AP) {
        this.AP = AP;
        this.c_name = c_name;
        this.c_rarity = c_rarity;
        this.skill = skill;
    }

    public int getAP() {
        return AP;
    }

    public String getC_name() {
        return c_name;
    }

    public String getC_rarity() {
        return c_rarity;
    }

    public String getSkill() {
        return skill;
    }
}
