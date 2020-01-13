package com.thoughtworks.marsrover;

import org.junit.Test;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MarsHandlerTest {
    @Test
    public void should_handle_init_order(){
        MarsPoint startPoint = new MarsPoint(0, 0);
        Direction startDirection = new Direction("N");
        MarsPosition expectedPosition = new MarsPosition(startPoint, startDirection);
        MarsOrder marsOrder = new MarsOrder(startPoint, startDirection);
        MarsPosition actualPosition = MarsHandler.Handle(Arrays.asList(marsOrder));
        assertEquals(expectedPosition, actualPosition);
    }
}
