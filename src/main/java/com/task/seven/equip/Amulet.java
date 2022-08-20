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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Amulet)) return false;
        Amulet amulet = (Amulet) o;
        return getName().equals(amulet.getName()) && Double.compare(getWeight(), amulet.getWeight()) == 0 &&
               Double.compare(getPrice(), amulet.getPrice()) == 0 && getMatter().equals(amulet.getMatter()) &&
               religion.equals(amulet.getReligion());
    }

    @Override
    public String toString() {
        return "Amulet{ name=" + getName() + ", weight=" + getWeight() + ", price=" + getPrice() +
               ", matter=" + getMatter() + ", religion=" + getReligion() + "} ";
    }
}
