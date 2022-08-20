package com.task.seven.exception;

// Copy of com.task.one.exception.InvalidPriceException
public class InvalidWeightException extends RuntimeException {
    private static final String DESCRIPTION = "Invalid weight: less than 0.";
    private double weight;

    public InvalidWeightException(double weight) {
        this.weight = weight;
    }

    public InvalidWeightException(double weight, String msg) {
        super(msg);
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "InvalidWeightException{" + "weight=" + weight + "} " + super.toString();
    }

    @Override
    public String getMessage() {
        return DESCRIPTION;
    }
}
