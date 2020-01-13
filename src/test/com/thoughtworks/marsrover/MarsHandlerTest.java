package com.thoughtworks.marsrover;

import com.thoughtworks.marsrover.model.*;
import org.junit.Test;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MarsHandlerTest {
    @Test
    public void should_handle_init_order(){
        MarsPoint startPoint = new MarsPoint(0, 0);
        MarsPosition expectedPosition = new MarsPosition(startPoint, Direction.N);
        MarsOrder marsOrder = new MarsOrder(startPoint, Direction.N);
        MarsPosition actualPosition = MarsHandler.Handle(Arrays.asList(marsOrder));
        assertEquals(expectedPosition, actualPosition);
    }
}
