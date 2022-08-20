package com.task.seven.equip;

import com.task.seven.exception.InvalidPriceException;
import com.task.seven.exception.InvalidWeightException;
import com.task.seven.gen.Item;

import java.util.Comparator;

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

    public static class ComparatorByWeight implements Comparator<Equipment> {
        @Override
        public int compare(Equipment o1, Equipment o2) {
            return Double.compare(o1.getWeight(), o2.getWeight());
        }
    }
}
