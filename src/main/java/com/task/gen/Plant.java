package com.task.gen;

public abstract class Plant {
    protected static final boolean leaves = true;
    protected static final boolean spikes = false;
    private double height;

    public Plant(double height) throws IllegalArgumentException {
        if (!setHeight(height)) {
            throw new IllegalArgumentException("Invalid price (less than 0).");
        }
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

    public boolean isLeaves() {
        return leaves;
    }

    public boolean isSpikes() {
        return spikes;
    }

    @Override
    public String toString() {
        return "Plant{" + "height=" + height + '}';
    }
}
