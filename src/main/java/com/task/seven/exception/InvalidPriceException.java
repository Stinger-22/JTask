package com.task.seven.exception;

// Copy of com.task.one.exception.InvalidPriceException
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
        return "InvalidPriceException{" + "price=" + price + "} ";
    }

    @Override
    public String getMessage() {
        return DESCRIPTION;
    }
}
