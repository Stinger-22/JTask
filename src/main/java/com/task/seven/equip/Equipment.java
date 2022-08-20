package com.task.seven.equip;

import com.task.seven.exception.InvalidPriceException;
import com.task.seven.exception.InvalidWeightException;
import com.task.seven.gen.Item;

public class Equipment implements Item {
    private String name;
    private double weight;
    private double price;

    public Equipment(String name, double weight, double price) {
        if (price <= 0) {
            throw new InvalidPriceException(price);
        }
        if (weight <= 0) {
            throw new InvalidWeightException(weight);
        }
        this.weight = weight;
        this.price = price;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Equipment{" + "name='" + name + '\'' + ", weight=" + weight + ", price=" + price + '}';
    }
}
