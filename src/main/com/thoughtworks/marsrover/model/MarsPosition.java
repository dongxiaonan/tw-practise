package com.thoughtworks.marsrover.model;

public class MarsPosition {
    public MarsPoint point;
    public Direction direction;

    public MarsPosition(MarsPoint initPoint, Direction initDirection) {
        point = initPoint;
        direction = initDirection;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null || obj.getClass() != this.getClass()){
            return false;
        }

        MarsPosition newOne = (MarsPosition)obj;
        return this.point == newOne.point && this.direction == newOne.direction;
    }
}
