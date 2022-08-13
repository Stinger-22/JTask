package com.task.flowers;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FlowerTest {
    private Flower flower;

    @Before
    public void setupFlowerTest() {
        this.flower = new Flower(25, "Blue", 77, 14);
    }

    @Test
    public void flowerConstructorHeightTest() {
        try {
            Flower flower1 = new Flower(10, "White", 5, -1);
            fail("Exception \"IllegalArgumentException\" must've been thrown. Height of flower is negative number in constructor!");
        }
        catch (IllegalArgumentException exception) {
            if (!exception.getMessage().equals("Invalid height (less than 0).")) {
                fail("Unexpected exception message. Must've been \"Invalid height (less than 0).\"");
            }
        }
        try {
            Flower flower2 = new Flower(10, "White", 43, 0);
            fail("Exception \"IllegalArgumentException\" must've been thrown. Height of flower is zero in constructor!");
        }
        catch (IllegalArgumentException exception) {
            if (!exception.getMessage().equals("Invalid height (less than 0).")) {
                fail("Unexpected exception message. Must've been \"Invalid height (less than 0).\"");
            }
        }
    }

    @Test
    public void flowerConstructorPriceTest() {
        try {
            Flower flower1 = new Flower(-7, "White", 25, 6);
            fail("Exception \"IllegalArgumentException\" must've been thrown. Price of flower is negative number in constructor!");
        }
        catch (IllegalArgumentException exception) {
            if (!exception.getMessage().equals("Invalid price (less than 0).")) {
                fail("Unexpected exception message. Must've been \"Invalid price (less than 0).\"");
            }
        }
        try {
            Flower flower2 = new Flower(0, "White", 5, 11);
            fail("Exception \"IllegalArgumentException\" must've been thrown. Price of flower is zero in constructor!");
        }
        catch (IllegalArgumentException exception) {
            if (!exception.getMessage().equals("Invalid price (less than 0).")) {
                fail("Unexpected exception message. Must've been \"Invalid price (less than 0).\"");
            }
        }
    }

    @Test
    public void flowerConstructorFreshTest() {
        try {
            Flower flower1 = new Flower(1, "White", -4, 9);
            fail("Exception \"IllegalArgumentException\" must've been thrown. Flower freshness is less than zero!");
        }
        catch (IllegalArgumentException exception) {
            if (!exception.getMessage().equals("Invalid freshness (not in range 0-100).")) {
                fail("Unexpected exception message. Must've been \"Invalid freshness (not in range 0-100).\"");
            }
        }
        try {
            Flower flower2 = new Flower(5, "White", 101, 10);
            fail("Exception \"IllegalArgumentException\" must've been thrown. Flower freshness is above hundred!");
        }
        catch (IllegalArgumentException exception) {
            if (!exception.getMessage().equals("Invalid freshness (not in range 0-100).")) {
                fail("Unexpected exception message. Must've been \"Invalid freshness (not in range 0-100).\"");
            }
        }
    }

    @Test
    public void flowerSetPriceTest() {
        assertFalse("Flower price is set to zero!", flower.setPrice(0));
        assertFalse("Flower price is set to negative number!", flower.setPrice(-76));
    }

    @Test
    public void flowerSetColorTest() {
        flower.setColor("Dark blue");
        assertEquals("Flower color wasn't set properly with \"setColor()\" method!", "Dark blue", flower.getColor());
    }

    @Test
    public void flowerSetFreshTest() {
        flower.setFresh(45);
        assertEquals("Flower fresh wasn't set properly with \"setFresh()\" method!", 45, flower.getFresh());
        assertFalse("Flower fresh was set above hundred!", flower.setFresh(101));
        assertFalse("Flower fresh was set below zero!", flower.setFresh(-1));
    }
}
