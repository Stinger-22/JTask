package com.task.accessories;

import org.junit.Test;
import static org.junit.Assert.*;

public class AccessoryTest {

    @Test
    public void AccessoryConstructorTest() {
        try {
            Accessory accessory = new Accessory(-1, "Balloon", "Red");
            fail("Exception \"IllegalArgumentException\" must've been thrown. Price of accessory is negative number in constructor!");
        }
        catch (IllegalArgumentException exception) {
            if (!exception.getMessage().equals("Invalid price (less than 0).")) {
                fail("Unexpected exception message. Must've been \"Invalid price (less than 0).\"");
            }
        }
        try {
            Accessory accessory = new Accessory(0, "Balloon", "Red");
            fail("Exception \"IllegalArgumentException\" must've been thrown. Price of accessory is zero in constructor!");
        }
        catch (IllegalArgumentException exception) {
            if (!exception.getMessage().equals("Invalid price (less than 0).")) {
                fail("Unexpected exception message. Must've been \"Invalid price (less than 0).\"");
            }
        }
    }
}
