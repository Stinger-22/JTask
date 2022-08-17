package com.task.flowers;

public class Dandelion extends Flower implements ISellFlower {
    private final static String NAME = "Dandelion";
    public Dandelion(double price, String color, int fresh, double height) {
        super(price, color, fresh, height);
    }

    public String getName() {
        return NAME;
    }

    @Override
    public String toString() {
        return "name=" + NAME + ", spikes=" + SPIKES + ", leaves=" + LEAVES + " " + super.toString();
    }
}
