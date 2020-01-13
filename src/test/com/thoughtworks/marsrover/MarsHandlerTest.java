package com.thoughtworks.marsrover;

import com.thoughtworks.marsrover.model.*;
import org.junit.Test;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MarsHandlerTest {
    @Test
    public void should_handle_init_order(){
        MarsPoint startPoint = new MarsPoint(0, 0);
        MarsPosition expectedPosition = new MarsPosition(startPoint, Direction.N);
        MarsOrder marsOrder = new MarsOrder(startPoint, Direction.N);
        MarsPosition actualPosition = MarsHandler.Handle(Arrays.asList(marsOrder));
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
}
