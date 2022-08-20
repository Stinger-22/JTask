package com.task.seven.equip;

public class Ring extends Jewelry {
    private String gem;

    public Ring(String name, double weight, double price, String matter, String gem) {
        super(name, weight, price, matter);
        this.gem = gem;
    }

    public String getGem() {
        return gem;
    }

    @Override
    public String toString() {
        return "Ring{ name=" + getName() + ", weight=" + getWeight() + ", price=" + getPrice() +
                ", matter=" + getMatter() + ", gem=" + getGem() + "} ";
    }
}
