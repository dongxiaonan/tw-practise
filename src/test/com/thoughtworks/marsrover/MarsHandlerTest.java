package com.thoughtworks.marsrover;

import com.thoughtworks.marsrover.model.*;
import org.junit.Test;
import java.util.Arrays;

import static org.junit.Assert.*;

public class MarsHandlerTest {
    @Test
    public void should_handle_init_order(){
        MarsPoint startPoint = new MarsPoint(0, 0);
        MarsPosition expectedPosition = new MarsPosition(startPoint, Direction.N);
        MarsOrder marsOrder = new MarsOrder(startPoint, Direction.N);
        MarsPosition actualPosition = MarsHandler.handle(Arrays.asList(marsOrder));
        assertEquals(expectedPosition, actualPosition);
    }

    @Test
    public void should_not_equal_when_direction_not_same(){
        MarsPosition positionOne = new MarsPosition(new MarsPoint(0, 0), Direction.N);
        MarsPosition positionTwo = new MarsPosition(new MarsPoint(0, 0), Direction.S);
        assertNotEquals(positionOne, positionTwo);
    }

    @Test
    public void should_not_equal_when_point_not_same(){
        MarsPosition positionOne = new MarsPosition(new MarsPoint(0, 0), Direction.N);
        MarsPosition positionTwo = new MarsPosition(new MarsPoint(0, 1), Direction.N);
        assertNotEquals(positionOne, positionTwo);
    }

    @Test
    public void should_equal_when_point_same_and_direction_same(){
        MarsPosition positionOne = new MarsPosition(new MarsPoint(0, 0), Direction.N);
        MarsPosition positionTwo = new MarsPosition(new MarsPoint(0, 0), Direction.N);
        assertEquals(positionOne, positionTwo);
    }

    @Test
    public void should_move_next_when_handle_move_order(){
        MarsPoint startPoint = new MarsPoint(0, 0);
        MarsOrder initOrder = new MarsOrder(startPoint, Direction.N);
        MarsOrder moveOrder = new MarsOrder(OrderType.MOVE);
        MarsPosition actualPosition = MarsHandler.handle(Arrays.asList(initOrder, moveOrder));
        assertEquals(new MarsPosition(new MarsPoint(0, 1), Direction.N), actualPosition);
    }

    @Test
    public void should_turn_left_when_handle_turn_left_order(){
        MarsPoint startPoint = new MarsPoint(0, 0);
        MarsOrder initOrder = new MarsOrder(startPoint, Direction.N);
        MarsOrder turnLeftOrder = new MarsOrder(OrderType.TURNL);
        MarsPosition actualPosition = MarsHandler.handle(Arrays.asList(initOrder, turnLeftOrder));
        assertEquals(new MarsPosition(startPoint, Direction.W), actualPosition);
    }

    @Test
    public void should_turn_right_when_handle_turn_right_order(){
        MarsPoint startPoint = new MarsPoint(0, 0);
        MarsOrder initOrder = new MarsOrder(startPoint, Direction.N);
        MarsOrder turnRightOrder = new MarsOrder(OrderType.TURNR);
        MarsPosition actualPosition = MarsHandler.handle(Arrays.asList(initOrder, turnRightOrder));
        assertEquals(new MarsPosition(startPoint, Direction.E), actualPosition);
    }

    @Test
    public void should_return_position_when_handle_order_list(){
        MarsPoint startPoint = new MarsPoint(0, 0);
        MarsOrder initOrder = new MarsOrder(startPoint, Direction.N);
        MarsOrder moveOrder = new MarsOrder(OrderType.MOVE);
        MarsOrder turnLeftOrder = new MarsOrder(OrderType.TURNL);
        MarsOrder turnRightOrder = new MarsOrder(OrderType.TURNR);

        MarsPosition actualPosition = MarsHandler.handle(Arrays.asList(initOrder, moveOrder, turnRightOrder, moveOrder, turnLeftOrder));
        assertEquals(new MarsPosition(new MarsPoint(1, 1), Direction.N), actualPosition);
    }

    @Test
    public void should_return_null_when_no_init_order(){
        MarsOrder moveOrder = new MarsOrder(OrderType.MOVE);
        assertNull(MarsHandler.handle(Arrays.asList(moveOrder)));
    }

    @Test
    public void should_return_null_when_init_order_not_first(){
        MarsPoint startPoint = new MarsPoint(0, 0);
        MarsOrder initOrder = new MarsOrder(startPoint, Direction.N);

        MarsOrder moveOrder = new MarsOrder(OrderType.MOVE);
        assertNull(MarsHandler.handle(Arrays.asList(moveOrder, initOrder)));
    }

    @Test
    public void should_return_null_when_more_than_one_init_order(){
        MarsPoint startPoint = new MarsPoint(0, 0);
        MarsOrder initOrder = new MarsOrder(startPoint, Direction.N);

        MarsOrder moveOrder = new MarsOrder(OrderType.MOVE);
        assertNull(MarsHandler.handle(Arrays.asList(initOrder, moveOrder, initOrder)));
    }

    @Test
    public void should_return_null_order_when_contains_invalid_order(){
        MarsPoint startPoint = new MarsPoint(0, 0);
        MarsOrder initOrder = new MarsOrder(startPoint, Direction.N);

        assertNull(MarsHandler.handle(Arrays.asList(initOrder, null)));
    }
}
