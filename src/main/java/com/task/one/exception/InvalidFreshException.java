package com.task.one.exception;

public class InvalidFreshException extends RuntimeException {
    private static final String DESCRIPTION = "Invalid freshness: not in range 0-100.";
    private int fresh;

    public InvalidFreshException(int fresh) {
        this.fresh = fresh;
    }

    public InvalidFreshException(int fresh, String msg) {
        super(msg);
        this.fresh = fresh;
    }

    @Override
    public String toString() {
        return "InvalidHeightException{" + "fresh=" + fresh + "} " + super.toString();
    }

    @Override
    public String getMessage() {
        return DESCRIPTION;
    }
}
