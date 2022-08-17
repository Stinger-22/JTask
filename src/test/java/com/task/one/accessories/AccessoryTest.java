package com.task.one.accessories;

import com.task.one.exception.InvalidPriceException;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccessoryTest {

    @Test
    public void AccessoryConstructorTest() throws InvalidPriceException {
        try {
            Accessory accessory1 = new Accessory(-1, "Balloon", "Red");
            Accessory accessory2 = new Accessory(0, "Balloon", "Red");
            fail("Exception \"InvalidPriceException\" must've been thrown. Price of accessory is negative number or zero in constructor!");
        }
        catch (InvalidPriceException exception) {
        }
    }
}
