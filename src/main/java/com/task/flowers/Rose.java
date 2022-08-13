package com.task.flowers;

public class Rose extends Flower implements ISellFlower {
    private final static String name = "Rose";
    private static final boolean spikes = true;
    public Rose(double price, String color, int fresh, double height) {
        super(price, color, fresh, height);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "name=" + name + ", spikes=" + spikes + ", leaves=" + leaves + " " + super.toString();
    }
}
