package com.task.flowers;

public class PearCactus extends Flower implements ISellFlower {
    private final static String name = "Pear Cactus";
    private static final boolean leaves = false;
    private static final boolean spikes = true;

    public PearCactus(double price, String color, int fresh, double height) {
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
