package com.task.seven.creature;

import static org.junit.Assert.*;

import com.task.seven.equip.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KnightTest {
    private Knight knight;

    @Before
    public void setupKnightTest() {
        this.knight = new Knight("John", 100);
    }

    @Test
    public void canGrabTest() {
        assertFalse(knight.canGrab(new Armor("Giant Chestplate", 150, 1000, 45, BodyParts.CHEST)));
        assertTrue(knight.canGrab(new Armor("Chestplate", 30, 400, 15, BodyParts.CHEST)));
    }

    @Test
    public void equipDropTest() {
        // Armor
        knight.equip(new Armor("Chestplate", 30, 400, 15, BodyParts.CHEST));
        assertEquals(15, knight.getDefense());
        knight.dropArmor(BodyParts.CHEST);
        assertEquals(0, knight.getDefense());

        // Ring
        knight.equip(new Ring("Golden ring", 0.3, 300, "Gold", "Ruby"));
        assertEquals(0.3, knight.getCarryNow(), 0);
        knight.equip(new Ring("Golden ring", 0.3, 300, "Gold", "Ruby"));
        knight.equip(new Ring("Silver ring", 0.25, 300, "Silver", "Saphire"));
        assertEquals(knight.getRing(), new Ring("Silver ring", 0.25, 300, "Silver", "Saphire"));
        knight.dropRing();
        assertNull(knight.getRing());

        // Amulet
        knight.equip(new Amulet("Catholic amulet with silver necklace", 0.32, 600, "Silver", "Catholic"));
        assertEquals(knight.getAmulet(), new Amulet("Catholic amulet with silver necklace", 0.32, 600, "Silver", "Catholic"));
        assertNotEquals(knight.getAmulet(), new Amulet("Amulet with silver necklace", 0.32, 600, "Silver", "Satanism"));
        assertTrue(knight.dropAmulet());
        assertFalse(knight.dropAmulet());

        // Weapon
        knight.equip(new Weapon("Iron sword", 7, 150, 9, false));
        assertNull(knight.getEquipPiece(BodyParts.LEFT_HAND));
        knight.equip(new Armor("Blue shield", 6, 100, 3, BodyParts.LEFT_HAND));
        knight.equip(new Weapon("Claymore", 10, 250, 16, true));
        assertEquals(knight.getEquipPiece(BodyParts.LEFT_HAND), new Weapon("Claymore", 10, 250, 16, true));
        assertEquals(knight.getEquipPiece(BodyParts.RIGHT_HAND), new Weapon("Claymore", 10, 250, 16, true));
        assertEquals(16, knight.getDamage());
    }

    @Test
    public void getEquipSortTest() {
        knight.equip(new Ring("Golden ring", 0.3, 300, "Gold", "Ruby"));
        knight.equip(new Amulet("Amulet with silver necklace", 0.32, 600, "Silver", "Satanism"));
        knight.equip(new Weapon("Claymore", 10, 250, 16, true));
        knight.equip(new Armor("Chestplate of England", 23, 320, 11, BodyParts.CHEST));
        knight.equip(new Armor("Used greaves", 11, 230, 6, BodyParts.LEGS));

        List<Equipment> expectedEquip = new ArrayList<>();
        expectedEquip.add(new Ring("Golden ring", 0.3, 300, "Gold", "Ruby"));
        expectedEquip.add(new Amulet("Amulet with silver necklace", 0.32, 600, "Silver", "Satanism"));
        expectedEquip.add(new Weapon("Claymore", 10, 250, 16, true));
        expectedEquip.add(new Armor("Chestplate of England", 23, 320, 11, BodyParts.CHEST));
        expectedEquip.add(new Armor("Used greaves", 11, 230, 6, BodyParts.LEGS));

        expectedEquip.sort(new Equipment.ComparatorByWeight());

        assertEquals(expectedEquip, Knight.Utils.EquipSortWeight(knight));
    }

    @Test
    public void findByPriceTest() {
        knight.equip(new Ring("Golden ring", 0.3, 300, "Gold", "Ruby"));
        knight.equip(new Amulet("Amulet with silver necklace", 0.32, 600, "Silver", "Satanism"));
        knight.equip(new Weapon("Claymore", 10, 250, 16, true));
        knight.equip(new Armor("Chestplate of England", 23, 320, 11, BodyParts.CHEST));
        knight.equip(new Armor("Used greaves", 11, 230, 6, BodyParts.LEGS));

        List<Equipment> found = Knight.Utils.findEquipByPrice(knight, 240, 400);
        found.sort(new Equipment.ComparatorByWeight());

        List<Equipment> expectedEquip = new ArrayList<>();
        expectedEquip.add(new Ring("Golden ring", 0.3, 300, "Gold", "Ruby"));
        expectedEquip.add(new Weapon("Claymore", 10, 250, 16, true));
        expectedEquip.add(new Armor("Chestplate of England", 23, 320, 11, BodyParts.CHEST));
        expectedEquip.sort(new Equipment.ComparatorByWeight());

        assertEquals(expectedEquip, found);
    }
}
