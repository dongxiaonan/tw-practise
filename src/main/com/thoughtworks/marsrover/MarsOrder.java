package com.thoughtworks.marsrover;

public class MarsOrder {
    public OrderType orderType = null;
    public MarsPoint startPoint = null;
    public Direction startDirection = null;
    public MarsOrder(MarsPoint point, Direction direction) {
        orderType = OrderType.INIT;
        startPoint = point;
        startDirection = direction;
    }
}

