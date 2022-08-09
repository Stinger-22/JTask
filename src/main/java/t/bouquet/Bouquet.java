package t.bouquet;

import t.bouquet.accesories.Accessory;
import t.bouquet.flowers.Flower;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Bouquet {
    private ArrayList<Flower> flowers;
    private ArrayList<Accessory> accessories;
    private double price = 0.0;

    public Bouquet() {
        flowers = new ArrayList<>();
        accessories = new ArrayList<>();
    }

    public Bouquet(ArrayList<Flower> flowers) {
        this.flowers = flowers;
        this.accessories = new ArrayList<>();
        this._price();
    }

    public Bouquet(ArrayList<Flower> flowers, ArrayList<Accessory> accessories) {
        this.flowers = flowers;
        this.accessories = accessories;
        this._price();
    }

    public void addFlower(Flower flower) {
        flowers.add(flower);
        price += flower.getPrice();
    }

    public void removeFlower(Flower flower) {
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
        Comparator<Flower> c = new Flower.FlowerCFresh();
        Collections.sort(this.flowers, c);
    }

    private void _price() {
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

    public Flower findHeight(double a, double b) {
        double h;
        for (int i = 0; i < flowers.size(); i++) {
            h = flowers.get(i).getHeight();
            if (h >= a && h <= b) {
                return flowers.get(i);
            }
        }
        return null;
    }
}
