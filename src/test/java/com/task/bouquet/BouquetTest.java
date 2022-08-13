package com.task.bouquet;

import com.task.accessories.Accessory;
import com.task.flowers.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BouquetTest {
    private Bouquet bouquet;

    @Before
    public void setupBouquetTest() {
        List<ISellFlower> flowers = new ArrayList<>();
        flowers.add(new Poppy(10, "Red", 80, 10));
        flowers.add(new Rose(15, "White", 100, 11));
        flowers.add(new Dandelion(12, "White", 90, 15));

        List<Accessory> accessories = new ArrayList<>();
        accessories.add(new Accessory(24, "Ribbon", "Green"));
        accessories.add(new Accessory(20, "Cover", "White"));

        this.bouquet = new Bouquet(flowers, accessories);
    }

    @Test
    public void bouquetAddRemoveFlowerTest() {
        ISellFlower flower = new Poppy(10 , "Red", 80, 20);
        bouquet.addFlower(flower);
        assertEquals("Price of bouquet didn't change when new flower was added.", 91, bouquet.getPrice(), 0);
        bouquet.removeFlower(flower);
        assertEquals("Price of bouquet didn't change when flower was removed.", 81, bouquet.getPrice(), 0);
    }


    @Test
    public void bouquetAddRemoveAccessoryTest() {
        Accessory accessory = new Accessory(20, "Balloon", "Red");
        bouquet.addAccessory(accessory);
        assertEquals("Price of bouquet didn't change when new accessory was added.", 101, bouquet.getPrice(), 0);
        bouquet.removeAccessory(accessory);
        assertEquals("Price of bouquet didn't change when accessory was removed.", 81, bouquet.getPrice(), 0);
    }

    @Test
    public void sortTest() {
        List<ISellFlower> sortedFlowers = new ArrayList<>();
        sortedFlowers.add(new Poppy(10, "Red", 80, 10));
        sortedFlowers.add(new Dandelion(12, "White", 90, 15));
        sortedFlowers.add(new Rose(15, "White", 100, 11));
        bouquet.sort();
        assertEquals("Bouquet flowers aren't properly sorted.", sortedFlowers, bouquet.getFlowers());
    }

    @Test
    public void freshnessTest() {
        assertEquals("Bouquet freshness wasn't properly calculated.", 90, bouquet.freshness(), 0.1);
    }

    @Test
    public void findFlowerWithHeightTest() {
        IFlower flower = new Dandelion(12, "White", 90, 15);
        assertEquals("Found wrong flower with given height range!", flower, bouquet.findFlowerWithHeight(12, 17));
    }
}
