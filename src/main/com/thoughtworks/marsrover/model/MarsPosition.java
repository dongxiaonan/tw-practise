package com.thoughtworks.marsrover.model;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class MarsPosition {
    public MarsPoint point;
    public Direction direction;

    public MarsPosition(MarsPoint initPoint, Direction initDirection) {
        point = initPoint;
        direction = initDirection;
    }
}
