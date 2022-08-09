package t.bouquet.flowers;

import java.util.Comparator;

public abstract class Flower {
    private double price;
    private String color;   // int?
    private int fresh;   // 0-100
    private double height;

    public Flower(double price, String color, int fresh, double height) {
        this.price = price;
        this.color = color;
        this.fresh = fresh;
        this.height = height;
    }

    public double getPrice() {
        return price;
    }

    public boolean setPrice(double price) {
        if (price > 0) {
            this.price = price;
            return true;
        }
        return false;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getFresh() {
        return fresh;
    }

    public boolean setFresh(int fresh) {
        if (fresh <= 100 && fresh >= 0) {
            this.fresh = fresh;
            return true;
        }
        return false;
    }

    public double getHeight() {
        return height;
    }

    public boolean setHeight(double height) {
        if (height > 0) {
            this.height = height;
            return true;
        }
        return false;
    }

    public abstract String getName();
    public abstract boolean isSpiky();

    @Override
    public String toString() {
        return "Flower{" + "name='" + getName() + '\'' + ", price=" + price + ", color=" + color + ", fresh=" + fresh +
               ", height=" + height + ", spiky=" + isSpiky() + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flower flower = (Flower) o;
        return Double.compare(flower.price, price) == 0 && fresh == flower.fresh &&
               Double.compare(flower.height, height) == 0 && color.equals(flower.color);
    }

    public static class FlowerCFresh implements Comparator<Flower> {
        @Override
        public int compare(Flower o1, Flower o2) {
            return o1.getFresh() - o2.getFresh();
        }
    }
}