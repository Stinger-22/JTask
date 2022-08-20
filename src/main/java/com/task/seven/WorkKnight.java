package com.task.seven;

import com.task.seven.equip.*;
import com.task.seven.creature.BodyParts;
import com.task.seven.creature.Human;
import com.task.seven.creature.Knight;

import java.util.List;
import java.util.Scanner;

public class WorkKnight {
    public static void main(String[] args) {
        System.out.println("I'm going to create knight!");
        Human human = new Human("Jack");
        System.out.println(human);

        Knight knight = new Knight("Sir Ivanhoe", 100);
        knight.equip(new Weapon("Iron sword", 7, 150, 9, false));
        knight.equip(new Armor("Blue shield", 6, 100, 3, BodyParts.LEFT_HAND));
        knight.equip(new Armor("Chestplate of England", 23, 320, 11, BodyParts.CHEST));
        knight.equip(new Armor("Used greaves", 11, 230, 6, BodyParts.LEGS));
        knight.equip(new Ring("Golden ring", 0.3, 300, "Gold", "Ruby"));

        List<Equipment> sortedEquipByWeight = Knight.Utils.EquipSortWeight(knight);
        System.out.println("Equip of knight sorted by weight: " + sortedEquipByWeight);

        System.out.print("Write min and max price of equipment: ");
        Scanner scanner = new Scanner(System.in);
        int min, max;
        min = scanner.nextInt();
        max = scanner.nextInt();
        List<Equipment> findEquipByPrice = Knight.Utils.findEquipByPrice(knight, min, max);
        System.out.println("Equip of knight in given price ringe: " + findEquipByPrice);
    }
}
