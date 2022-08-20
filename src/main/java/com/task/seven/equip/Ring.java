package com.task.seven.equip;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ring)) return false;
        Ring ring = (Ring) o;
        return getName().equals(ring.getName()) && Double.compare(getWeight(), ring.getWeight()) == 0 &&
               Double.compare(getPrice(), ring.getPrice()) == 0 && getMatter().equals(ring.getMatter()) &&
               gem.equals(ring.gem);
    }

    @Override
    public String toString() {
        return "Ring{ name=" + getName() + ", weight=" + getWeight() + ", price=" + getPrice() +
                ", matter=" + getMatter() + ", gem=" + getGem() + "} ";
    }
}
