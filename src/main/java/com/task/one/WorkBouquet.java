package com.task.one;

import com.task.one.accessories.Accessory;
import com.task.one.bouquet.Bouquet;
import com.task.one.flowers.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WorkBouquet {
    public static void main(String[] args) {

        List<ISellFlower> flowers = new ArrayList<>();
        flowers.add(new Poppy(10, "Red", 86, 12.5));
        flowers.add(new Rose(15, "White", 94, 13.4));
        flowers.add(new Dandelion(12, "White", 91, 10.2));

        List<Accessory> accessories = new ArrayList<>();
        accessories.add(new Accessory(24, "Ribbon", "Green"));
        accessories.add(new Accessory(20, "Cover", "White"));

        Bouquet bouquet = new Bouquet(flowers, accessories);

        bouquet.sort();
        System.out.println(bouquet);
        System.out.println("Bouquet price: " + bouquet.getPrice());
        System.out.println("Bouquet freshness: " + bouquet.freshness());

        System.out.print("Find flower which fits given height range: ");
        Scanner scanner = new Scanner(System.in);
        int a, b;
        a = scanner.nextInt();
        b = scanner.nextInt();
        System.out.println("Found flowers: " + bouquet.findFlowersWithHeight(a, b));

        bouquet.addFlower(new PearCactus(120, "Yellow", 100, 8));
        System.out.println(bouquet);

    }
}
