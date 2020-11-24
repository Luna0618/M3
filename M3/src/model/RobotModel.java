package model;

public class RobotModel {
    private final String model;
    private final String enemies_name;

    public RobotModel(String model, String name) {
        this.model = model;
        this.enemies_name = name;
    }

    public String getEnemies_name() {
        return enemies_name;
    }

    public String getModel() {
        return model;
    }
}
