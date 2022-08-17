package com.task.one.exception;

public class InvalidPriceException extends RuntimeException {
    private static final String DESCRIPTION = "Invalid price: less than 0.";
    private double price;

    public InvalidPriceException(double price) {
        this.price = price;
    }

    public InvalidPriceException(double price, String msg) {
        super(msg);
        this.price = price;
    }

    @Override
    public String toString() {
        return "InvalidHeightException{" + "price=" + price + "} " + super.toString();
    }

    @Override
    public String getMessage() {
        return DESCRIPTION;
    }
}
