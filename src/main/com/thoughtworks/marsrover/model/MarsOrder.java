package com.thoughtworks.marsrover.model;

public class MarsOrder {
    public OrderType orderType = null;
    public MarsPoint startPoint = null;
    public Direction startDirection = null;
    public MarsOrder(MarsPoint point, Direction direction) {
        orderType = OrderType.INIT;
        startPoint = point;
        startDirection = direction;
    }

    public MarsOrder(OrderType orderType) {
        this.orderType = orderType;
    }
}

