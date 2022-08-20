package com.task.seven.equip;

public class Jewelry extends Equipment {
    private String matter;

    public Jewelry(String name, double weight, double price, String matter) {
        super(name, weight, price);
        this.matter = matter;
    }

    public String getMatter() {
        return matter;
    }

    @Override
    public String toString() {
        return "Jewelry{" + "matter='" + matter + '\'' + "} " + super.toString();
    }
}
