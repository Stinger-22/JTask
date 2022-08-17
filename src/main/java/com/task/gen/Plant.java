package com.task.gen;

import com.task.exception.InvalidHeightException;

import java.util.Objects;

public class Plant {
    protected static final boolean LEAVES = true;
    protected static final boolean SPIKES = false;
    protected double height;

    public Plant(double height) throws InvalidHeightException {
        if (!setHeight(height)) {
            throw new InvalidHeightException(height);
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
        return LEAVES;
    }

    public boolean isSpikes() {
        return SPIKES;
    }

    @Override
    public String toString() {
        return "Plant{" + "height=" + height + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plant)) return false;
        Plant plant = (Plant) o;
        return Double.compare(plant.height, height) == 0;
    }
}
