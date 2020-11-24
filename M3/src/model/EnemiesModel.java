package model;


public class EnemiesModel {
    private final String enemies_name;
    private final int enemy_AP;

    public EnemiesModel(String enemies_name, int enemy_AP) {
        this.enemies_name = enemies_name;
        this.enemy_AP = enemy_AP;
    }

    public String getEnemies_name() {
        return enemies_name;
    }

    public int getEnemy_AP() {
        return enemy_AP;
    }

}
