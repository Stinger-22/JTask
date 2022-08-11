package com.task.flowers;

public class Dandelion extends Flower {
    private final static String name = "Dandelion";
    public Dandelion(double price, String color, int fresh, double height) {
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
