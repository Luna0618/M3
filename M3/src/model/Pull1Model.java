package model;

public class Pull1Model {
    private final String gacha_name;
    private final int currency_cost;

    public Pull1Model(String gacha_name, int currency_cost) {
        this.gacha_name = gacha_name;
        this.currency_cost = currency_cost;

    }

    public int getCurrency_cost() {
        return currency_cost;
    }

    public String getGacha_name() {
        return gacha_name;
    }
}
