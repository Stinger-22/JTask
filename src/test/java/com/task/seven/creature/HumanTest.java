package com.task.seven.creature;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class HumanTest {
    private Human human;

    @Before
    public void setupHumanTest() {
        this.human = new Human("John");
    }

    @Test
    public void limbTest() {
        assertTrue(human.isLimb(BodyParts.HEAD));
        human.crippleLimb(BodyParts.HEAD);
        assertFalse(human.isLimb(BodyParts.HEAD));
        human.healLimb(BodyParts.HEAD);
        assertTrue(human.isLimb(BodyParts.HEAD));
    }
}
