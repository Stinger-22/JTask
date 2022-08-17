package com.task.exception;

public class InvalidHeightException extends RuntimeException {
    private static final String DESCRIPTION = "Invalid height: less than 0.";
    private double height;

    public InvalidHeightException(double height) {
            this.height = height;
    }

    public InvalidHeightException(double height, String msg) {
        super(msg);
        this.height = height;
    }

    @Override
    public String toString() {
        return "InvalidHeightException{" + "height=" + height + "} " + super.toString();
    }

    @Override
    public String getMessage() {
        return DESCRIPTION;
    }
}
