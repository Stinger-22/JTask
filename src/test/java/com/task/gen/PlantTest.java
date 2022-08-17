package com.task.gen;

import com.task.exception.InvalidHeightException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlantTest {
    private Plant plant;

    @Before
    public void setupPlantTest() throws InvalidHeightException {
        plant = new Plant(4);
    }

    @Test
    public void plantConstructorTest() {
        try {
            Plant plant1 = new Plant(-1);
            Plant plant2 = new Plant(0);
            fail("Exception \"InvalidHeightException\" must've been thrown");
        }
        catch (InvalidHeightException exception) {
        }
    }

    @Test
    public void plantSetHeightTest() {
        assertFalse("Plant height is set to below zero!", plant.setHeight(-2));
        assertFalse("Plant height is set to zero!", plant.setHeight(0));
    }

    @Test
    public void plantCompareTest() {
        assertEquals(plant, new Plant(4));
        assertNotEquals(plant, new Plant(5));
    }
}