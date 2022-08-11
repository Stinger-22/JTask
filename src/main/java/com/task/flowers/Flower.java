package com.task.flowers;

import com.task.gen.Plant;

public abstract class Flower extends Plant implements ISellFlower {
    private double price;
    private String color;
    private int fresh;   // 0-100

    public Flower(double price, String color, int fresh, double height) throws IllegalArgumentException {
        super(height);
        if (!setFresh(fresh)) {
            throw new IllegalArgumentException("Invalid freshness (not in range 0-100).");
        }
        if (!setPrice(price)) {
            throw new IllegalArgumentException("Invalid price (less than 0).");
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
    public String toString() {
        return "Flower{" + "price=" + price + ", color='" + color + '\'' + ", fresh=" + fresh + "} " + super.toString();
    }

}