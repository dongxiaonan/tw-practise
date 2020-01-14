package com.thoughtworks.marsrover.model;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class MarsPoint {
    public int marsX = 0;
    public int marsY = 0;

    public MarsPoint(int x, int y) {
        marsX = x; marsY = y;
    }
}
