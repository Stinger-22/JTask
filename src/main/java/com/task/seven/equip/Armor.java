package com.task.seven.equip;

import com.task.seven.creature.BodyParts;

public class Armor extends Equipment {
    private int defense;
    private BodyParts purpose;

    public Armor(String name, double weight, double price, int defense, BodyParts purpose) {
        super(name, weight, price);
        this.defense = defense;
        this.purpose = purpose;
    }

    public int getDefense() {
        return defense;
    }

    public BodyParts getPurpose() {
        return purpose;
    }

    @Override
    public String toString() {
        return "Armor{ name=" + getName() + ", weight=" + getWeight() + ", price=" + getPrice() +
               ", defense=" + defense + ", purpose=" + purpose + "} ";
    }
}
