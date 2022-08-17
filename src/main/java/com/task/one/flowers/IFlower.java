package com.task.one.flowers;

import java.util.Comparator;

public interface IFlower {
    String getName();
    String getColor();
    int getFresh();
    double getHeight();
    boolean isLeaves();
    boolean isSpikes();

    class ComparatorFlowerFresh implements Comparator<IFlower> {
        @Override
        public int compare(IFlower o1, IFlower o2) {
            return o1.getFresh() - o2.getFresh();
        }
    }
}
