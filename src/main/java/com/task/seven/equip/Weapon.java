package com.task.seven.equip;

import com.task.seven.creature.BodyParts;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Weapon)) return false;
        Weapon weapon = (Weapon) o;
        return getName().equals(weapon.getName()) && Double.compare(getWeight(), weapon.getWeight()) == 0 &&
               Double.compare(getPrice(), weapon.getPrice()) == 0 && damage == weapon.getDamage() &&
               doubleHanded == weapon.isDoubleHanded();
    }

    @Override
    public String toString() {
        return "Weapon{" + "damage=" + damage + ", doubleHanded=" + doubleHanded + "} " + super.toString();
    }
}
