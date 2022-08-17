package com.task.one.flowers;

import com.task.one.exception.InvalidFreshException;
import com.task.one.exception.InvalidHeightException;
import com.task.one.exception.InvalidPriceException;
import com.task.one.gen.Plant;

import java.util.Objects;

public class Flower extends Plant implements ISellFlower {
    private double price;
    private String color;
    private int fresh;   // 0-100

    public Flower(double price, String color, int fresh, double height)
            throws InvalidHeightException, InvalidFreshException, InvalidPriceException {
        super(height);
        if (!setFresh(fresh)) {
            throw new InvalidFreshException(fresh);
        }
        if (!setPrice(price)) {
            throw new InvalidPriceException(price);
        }
        this.color = color;
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

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flower)) return false;
        Flower flower = (Flower) o;
        return Double.compare(flower.height, height) == 0 && Double.compare(flower.price, price) == 0 &&
               fresh == flower.fresh && color.equals(flower.color) &&
               Objects.equals(this.getName(), ((Flower) o).getName()) &&
               Objects.equals(this.isLeaves(), ((Flower) o).isLeaves()) &&
               Objects.equals(this.isSpikes(), ((Flower) o).isSpikes());
    }

    @Override
    public String toString() {
        return "Flower{" + "price=" + price + ", color='" + color + '\'' + ", fresh=" + fresh +
               ", height=" + height + "} ";
    }
}
