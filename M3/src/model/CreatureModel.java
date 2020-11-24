package model;

public class CreatureModel {
    private final String Species;
    private final String enemies_name;

    public CreatureModel(String species, String name){
        this.Species = species;
        this.enemies_name = name;
    }

    public String getSpecies() {return Species;}

    public String getEnemies_name() {
        return enemies_name;
    }
}
