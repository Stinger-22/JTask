package com.task.seven.creature;

import com.task.seven.equip.Armor;
import com.task.seven.equip.Equipment;
import com.task.seven.equip.Amulet;
import com.task.seven.equip.Ring;
import com.task.seven.equip.Weapon;
import com.task.seven.gen.Item;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Knight extends Human {
    // Equip:
    // Body: Helmet - Chestplate - Gloves - Belt - Leggings - Ring(s?) - Amulet
    // Hands: one/two handed sword, bow, shield

    private EnumMap<BodyParts, Equipment> equipment;
    private Ring ring;
    private Amulet amulet;

    private int defense;
    private int damage;
    private double carryCap;
    private double carryNow;

    public Knight(String name, int carryCap) {
        super(name);
        this.damage = 0;
        this.defense = 0;
        this.carryNow = 0;
        this.carryCap = carryCap;
        this.equipment = new EnumMap<>(BodyParts.class);
    }

    public int getDefense() {
        return defense;
    }

    public int getDamage() {
        return damage;
    }

    public boolean equip(Armor armor) {
        if (this.canGrab(armor)) {
            BodyParts part = armor.getPurpose();
            dropArmor(part);
            this.equipment.put(part, armor);
            this.carryNow += armor.getWeight();
            this.defense += armor.getDefense();
            return true;
        }
        return false;
    }

    public boolean equip(Weapon weapon) {
        if (this.canGrab(weapon)) {
            dropWeapon();
            this.equipment.put(BodyParts.RIGHT_HAND, weapon);
            this.damage = weapon.getDamage();
            if (weapon.isDoubleHanded()) {
                this.equipment.put(BodyParts.LEFT_HAND, weapon);
                this.carryNow += weapon.getWeight();
            }
            return true;
        }
        return false;
    }

    public boolean equip(Ring ring) {
        if (this.canGrab(ring)) {
            dropRing();
            this.ring = ring;
            this.carryNow += ring.getWeight();
            return true;
        }
        return false;
    }

    public boolean equip(Amulet amulet) {
        if (this.canGrab(amulet)) {
            dropAmulet();
            this.amulet = amulet;
            this.carryNow += amulet.getWeight();
            return true;
        }
        return false;
    }

    public boolean dropWeapon()  {
        Weapon weapon = (Weapon) equipment.get(BodyParts.RIGHT_HAND);
        if (weapon == null) {
            return false;
        }
        this.carryNow -= weapon.getWeight();
        this.equipment.put(BodyParts.RIGHT_HAND, null);
        if (weapon.isDoubleHanded()) {
            this.equipment.put(BodyParts.LEFT_HAND, null);
        }
        this.damage = 0;
        return true;
    }

    public boolean dropArmor(BodyParts part) {
        Armor armor = (Armor) equipment.get(part);
        if (armor == null) {
            return false;
        }
        this.carryNow -= armor.getWeight();
        this.equipment.put(part, null);
        this.defense -= armor.getDefense();
        return true;
    }

    public boolean dropRing() {
        if (ring == null) {
            return false;
        }
        this.carryNow -= ring.getWeight();
        this.ring = null;
        return true;
    }

    public boolean dropAmulet() {
        if (amulet == null) {
            return false;
        }
        this.carryNow -= amulet.getWeight();
        this.amulet = null;
        return true;
    }

    public boolean canGrab(Item item) {
        if (item != null) {
            return carryNow + item.getWeight() <= carryCap;
        }
        return false;
    }

    public List<Equipment> getEquipment() {
        Stream<Equipment> equipStream = equipment.values().stream();
        List<Equipment> exportEquip = equipStream.filter(Objects::nonNull).collect(Collectors.toList());
        if (ring != null) {
            exportEquip.add(ring);
        }
        if (amulet != null) {
            exportEquip.add(amulet);
        }
        return exportEquip;
    }

    public static class Utils {
        public static List<Equipment> EquipSortWeight(Knight knight) {
            List<Equipment> equip = knight.getEquipment();
            equip.sort(Comparator.comparingDouble(Equipment::getWeight));
            return equip;
        }

        public static List<Equipment> findEquipByPrice(Knight knight, double min, double max) {
            List<Equipment> equip = knight.getEquipment();
            Stream<Equipment> streamEquip = equip.stream();
            return streamEquip.filter(e -> (e.getPrice() >= min && e.getPrice() <= max)).collect(Collectors.toList());
        }
    }
}
