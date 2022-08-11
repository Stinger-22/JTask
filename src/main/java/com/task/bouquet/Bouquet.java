package com.task.bouquet;

import com.task.flowers.IFlower;
import com.task.flowers.ISellFlower;
import com.task.gen.ISellable;
import com.task.accessories.Accessory;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class Bouquet implements ISellable {
    private List<ISellFlower> flowers;
    private List<Accessory> accessories;
    private double price = 0.0;

    public Bouquet() {
        flowers = new ArrayList<>();
        accessories = new ArrayList<>();
    }

    public Bouquet(List<ISellFlower> flowers) {
        this.flowers = flowers;
        this.accessories = new ArrayList<>();
        this.setupPrice();
    }

    public Bouquet(List<ISellFlower> flowers, List<Accessory> accessories) {
        this.flowers = flowers;
        this.accessories = accessories;
        this.setupPrice();
    }

    public void addFlower(ISellFlower flower) {
        flowers.add(flower);
        price += flower.getPrice();
    }

    public void removeFlower(ISellFlower flower) {
        flowers.remove(flower);
        price -= flower.getPrice();
    }

    public void addAccessory(Accessory accessory) {
        accessories.add(accessory);
        price += accessory.getPrice();
    }

    public void removeAccessory(Accessory accessory) {
        accessories.remove(accessory);
        price -= accessory.getPrice();
    }

    public void sort() {
        Comparator<IFlower> c = new IFlower.ComparatorFlowerFresh();
        Collections.sort(this.flowers, c);
    }

    private void setupPrice() {
        for (int i = 0; i < flowers.size(); i++) {
            price += flowers.get(i).getPrice();
        }
        for (int i = 0; i < accessories.size(); i++) {
            price += accessories.get(i).getPrice();
        }
    }

    public double getPrice() {
        return this.price;
    }

    public double freshness() {
        double fresh = 0.0;
        int i = 0;
        for ( ; i < flowers.size(); i++) {
            fresh += flowers.get(i).getFresh();
        }
        return fresh / i;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("/Flowers: ");
        for (int i = 0; i < flowers.size(); i++) {
            sb.append(flowers.get(i).getName()).append(", ");
        }
        sb.append("/Accessories: ");
        for (int i = 0; i < accessories.size(); i++) {
            sb.append(accessories.get(i).getName()).append(", ");
        }
        return sb.toString();
    }

    public void print() {
        System.out.println("\nFlowers:");
        for (int i = 0; i < flowers.size(); i++) {
            System.out.println(flowers.get(i));
        }
        System.out.println("\nAccessories:");
        for (int i = 0; i < accessories.size(); i++) {
            System.out.println(accessories.get(i));
        }
    }

    public ISellFlower findFlowerWithHeight(double min, double max) {
        double h;
        for (int i = 0; i < flowers.size(); i++) {
            h = flowers.get(i).getHeight();
            if (h >= min && h <= max) {
                return flowers.get(i);
            }
        }
        return null;
    }
}
