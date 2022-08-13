package com.task.accessories;

import com.task.gen.ISellable;

public class Accessory implements ISellable {
    private double price;
    private String name;
    private String color;

    public Accessory(double price, String name, String color) throws IllegalArgumentException {
        if (price <= 0) {
            throw new IllegalArgumentException("Invalid price (less than 0).");
        }
        this.name = name;
        this.price = price;
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Accessory{" + "name='" + name + '\''+ "price=" + price + ", color='" + color + '\'' +  '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accessory accessory = (Accessory) o;
        return Double.compare(accessory.price, price) == 0 && name.equals(accessory.name) && color.equals(accessory.color);
    }
}
