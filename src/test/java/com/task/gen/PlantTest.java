package com.task.gen;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlantTest {
    private Plant plant;

    @Before
    public void setupPlantTest() {
        plant = new Plant(4);
    }

    @Test
    public void plantConstructorTest() {
        try {
            Plant plant1 = new Plant(-1);
            fail("Exception \"IllegalArgumentException\" must've been thrown");
        }
        catch (IllegalArgumentException exception) {
            if (!exception.getMessage().equals("Invalid height (less than 0).")) {
                fail("Unexpected exception message. Must've been \"Invalid height (less than 0).\"");
            }
        }
        try {
            Plant plant2 = new Plant(0);
            fail("Exception \"IllegalArgumentException\" must've been thrown");
        }
        catch (IllegalArgumentException exception) {
            if (!exception.getMessage().equals("Invalid height (less than 0).")) {
                fail("Unexpected exception message. Must've been \"Invalid height (less than 0).\"");
            }
        }
    }

    @Test
    public void plantSetHeightTest() {
        assertFalse("Plant height is set to below zero!", plant.setHeight(-2));
        assertFalse("Plant height is set to zero!", plant.setHeight(0));
    }

}