package com.thoughtworks.marsrover;

import com.thoughtworks.marsrover.model.Direction;
import com.thoughtworks.marsrover.model.MarsOrder;
import com.thoughtworks.marsrover.model.MarsPosition;
import com.thoughtworks.marsrover.model.OrderType;

import java.util.List;

public class MarsHandler {
    public static MarsPosition Handle(List<MarsOrder> marsOrder) {
        MarsOrder initOrder = marsOrder.get(0);
        if (initOrder == null || initOrder.orderType != OrderType.INIT){
            return null;
        }
        var position = new MarsPosition(initOrder.startPoint, initOrder.startDirection);

        for (int index = 1; index < marsOrder.size() ; index++) {
            MarsOrder order = marsOrder.get(index);
            switch (order.orderType){
                case MOVE -> MoveNext(position);
                case TURNL, TURNR -> Turn(order.orderType, position);
            }
        }

        return position;
    }

    private static void Turn(OrderType orderType, MarsPosition position) {
        int turn = 0;
        switch (orderType){
            case TURNR -> turn = 1;
            case TURNL -> turn = -1;
        }

        if (turn == 0){
            return;
        }

        Direction[] allDirections = Direction.values();
        int directionLength = allDirections.length;
        int newDirectionIndex = (directionLength + position.direction.ordinal() + turn) % directionLength;
        position.direction = allDirections[newDirectionIndex];
    }

    private static void MoveNext(MarsPosition position) {
        switch (position.direction){
            case N -> position.point.marsY++;
            case S -> position.point.marsY--;
            case E -> position.point.marsX++;
            case W -> position.point.marsX--;
        }
    }
}
