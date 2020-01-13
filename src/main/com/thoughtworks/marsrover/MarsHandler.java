package com.thoughtworks.marsrover;

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
                case MOVE:
                    switch (position.direction){
                        case N -> position.point.marsY++;
                        case S -> position.point.marsY--;
                        case E -> position.point.marsX++;
                        case W -> position.point.marsX--;
                    }
            }
        }

        return position;
    }
}
