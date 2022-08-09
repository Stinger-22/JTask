package t.bouquet;

import t.bouquet.accesories.Accessory;
import t.bouquet.flowers.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        ArrayList<Flower> flowers = new ArrayList<>();
        flowers.add(new Poppy(10, "Red", 86, 12.5));
        flowers.add(new Rose(15, "White", 94, 13.4));
        flowers.add(new Dandelion(12, "White", 91, 10.2));

        ArrayList<Accessory> accessories = new ArrayList<>();
        accessories.add(new Accessory(24, "Ribbon", "Green"));
        accessories.add(new Accessory(20, "Cover", "White"));

        Bouquet bouquet = new Bouquet(flowers, accessories);

        //bouquet.print();
        //System.out.println("Bouquet price: " + bouquet.getPrice());

        bouquet.sort();
        bouquet.print();
        System.out.println("Bouquet price: " + bouquet.getPrice());
        System.out.println("Bouquet freshness: " + bouquet.freshness());

        System.out.print("Find flower which fits given height range: ");
        Scanner scanner = new Scanner(System.in);
        int a, b;
        a = scanner.nextInt();
        b = scanner.nextInt();
        System.out.println(bouquet.findHeight(a, b));
    }
}
