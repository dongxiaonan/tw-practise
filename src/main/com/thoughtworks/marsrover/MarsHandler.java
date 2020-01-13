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
                case TURNL -> TurnLeft(position);
            }
        }

        return position;
    }

    private static void TurnLeft(MarsPosition position) {
        switch (position.direction){
            case N -> position.direction =Direction.W;
            case S -> position.direction =Direction.E;
            case E -> position.direction =Direction.N;
            case W -> position.direction =Direction.S;
        }
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
