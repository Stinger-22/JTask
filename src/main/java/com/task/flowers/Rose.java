package com.task.flowers;

public class Rose extends Flower implements ISellFlower {
    private final static String NAME = "Rose";
    private static final boolean SPIKES = true;
    public Rose(double price, String color, int fresh, double height) {
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
