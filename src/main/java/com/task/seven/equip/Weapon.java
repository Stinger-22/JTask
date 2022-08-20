package com.task.seven.equip;

public class Weapon extends Equipment {
    private int damage;
    private boolean doubleHanded;

    public Weapon(String name, double weight, double price, int damage) {
        super(name, weight, price);
        this.damage = damage;
        this.doubleHanded = false;
    }

    public Weapon(String name, double weight, double price, int damage, boolean doubleHanded) {
        super(name, weight, price);
        this.damage = damage;
        this.doubleHanded = doubleHanded;
    }

    public int getDamage() {
        return damage;
    }

    public boolean isDoubleHanded() {
        return doubleHanded;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "damage=" + damage +
                ", doubleHanded=" + doubleHanded +
                "} " + super.toString();
    }
}
