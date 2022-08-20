package com.task.seven.equip;

public class Amulet extends Jewelry {
    private String religion;

    public Amulet(String name, double weight, double price, String matter, String religion) {
        super(name, weight, price, matter);
        this.religion = religion;
    }

    public String getReligion() {
        return religion;
    }

    @Override
    public String toString() {
        return "Amulet{ name=" + getName() + ", weight=" + getWeight() + ", price=" + getPrice() +
               ", matter=" + getMatter() + ", religion=" + getReligion() + "} ";
    }
}
