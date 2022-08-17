package com.task.flowers;

public class PearCactus extends Flower implements ISellFlower {
    private final static String NAME = "Pear Cactus";
    private static final boolean LEAVES = false;
    private static final boolean SPIKES = true;

    public PearCactus(double price, String color, int fresh, double height) {
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
