package com.task.seven.creature;

import java.util.EnumMap;
import java.util.Map;

public class Human {
    protected String name;
    protected Map<BodyParts, Boolean> body;

    public Human(String name) {
        this.name = name;
        this.body = new EnumMap<>(BodyParts.class);
        body.put(BodyParts.HEAD, true);
        body.put(BodyParts.CHEST, true);
        body.put(BodyParts.LEFT_HAND, true);
        body.put(BodyParts.RIGHT_HAND, true);
        body.put(BodyParts.LEGS, true);
        body.put(BodyParts.FEET, true);
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", body=" + body +
                '}';
    }

    public String getName() {
        return name;
    }

    public boolean isLimb(BodyParts part) {
        return body.get(part);
    }

    public void crippleLimb(BodyParts part) {
        body.put(part, false);
    }

    public void healLimb(BodyParts part) {
        body.put(part, true);
    }
}
