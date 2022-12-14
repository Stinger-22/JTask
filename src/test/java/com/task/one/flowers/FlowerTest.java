package com.task.one.flowers;

import com.task.one.exception.InvalidFreshException;
import com.task.one.exception.InvalidHeightException;
import com.task.one.exception.InvalidPriceException;
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
    public void flowerConstructorTest()
            throws InvalidHeightException, InvalidFreshException, InvalidPriceException {
        try {
            Flower flower1 = new Flower(10, "White", 5, -1);
            Flower flower2 = new Flower(10, "White", 43, 0);
            fail("Exception \"InvalidHeightException\" must've been thrown");
        }
        catch (InvalidHeightException exception) {
        }
        try {
            Flower flower3 = new Flower(-7, "White", 25, 6);
            Flower flower4 = new Flower(0, "White", 5, 11);
            fail("Exception \"InvalidPriceException\" must've been thrown");
        }
        catch (InvalidPriceException exception) {
        }
        try {
            Flower flower5 = new Flower(1, "White", -4, 9);
            Flower flower6 = new Flower(5, "White", 101, 10);
            fail("Exception \"InvalidFreshException\" must've been thrown");
        }
        catch (InvalidFreshException exception) {
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

    @Test
    public void flowerCompareTest() {
        assertEquals(flower, new Flower(25, "Blue", 77, 14));
        assertNotEquals(flower, new Flower(25, "Green", 77, 14));
    }
}
