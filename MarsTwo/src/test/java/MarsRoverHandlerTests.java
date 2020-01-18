import Model.Command;
import Model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MarsRoverHandlerTests {
    private Map<MarsPosition, String> marsMap;
    private MarsRover rover;
    private MarsRadar marsRadar;

    @Before
    public void setup(){
        marsMap = new HashMap<>();
        marsRadar = mock(MarsRadar.class);
        var marsRoverFactory = new MarsRoverFactory(marsMap, marsRadar);
        MarsPosition marsPosition = new MarsPosition(0, 0);
        rover = marsRoverFactory.init(marsPosition, MarsDirection.N);
    }
    @Test
    public void should_init_rover_with_init_status(){
        Assert.assertEquals(new MarsPosition(0, 0), rover.position);
        Assert.assertEquals(MarsDirection.N, rover.facing);
        Assert.assertEquals(RoverWorkStatus.Forward, rover.workStatus);
    }

    @Test
    public void should_move_when_get_M_command(){
        rover.handle(Arrays.asList(Command.M));
        Assert.assertEquals(new MarsPosition(0, 1), rover.position);
    }

    @Test
    public void should_move_when_get_L_command(){
        rover.handle(Arrays.asList(Command.L));
        Assert.assertEquals(MarsDirection.W, rover.facing);
    }

    @Test
    public void should_move_when_get_R_command(){
        rover.handle(Arrays.asList(Command.R));
        Assert.assertEquals(MarsDirection.E, rover.facing);
    }

    @Test
    public void should_backward_when_get_B_command(){
        rover.handle(Arrays.asList(Command.B));
        Assert.assertEquals(MarsDirection.N, rover.facing);
        Assert.assertEquals(RoverWorkStatus.Backward, rover.workStatus);

        rover.handle(Arrays.asList(Command.B, Command.B));
        Assert.assertEquals(RoverWorkStatus.Forward, rover.workStatus);

        rover.handle(Arrays.asList(Command.B, Command.M));
        Assert.assertEquals(new MarsPosition(0, -1), rover.position);

        rover.handle(Arrays.asList(Command.B, Command.L));
        Assert.assertEquals(MarsDirection.E, rover.facing);

        rover.handle(Arrays.asList(Command.B, Command.R));
        Assert.assertEquals(MarsDirection.W, rover.facing);
    }

    @Test
    public void should_mark_in_map_when_rover_is_in_hole(){
        when(marsRadar.isInHole()).thenReturn(true);
        Assert.assertFalse(marsMap.containsKey(new MarsPosition(0, 1)));

        rover.handle(Arrays.asList(Command.M));
        Assert.assertEquals("X", marsMap.get(new MarsPosition(0, 1)));
    }

    @Test
    public void should_ignore_command_when_go_to_hole(){
        marsMap.put(new MarsPosition(0, 1), "X");

        rover.handle(Arrays.asList(Command.M));
        Assert.assertEquals(new MarsPosition(0, 0), rover.position);
    }

    @Test
    public void should_ignore_command_when_rover_on_can_move_range(){
        marsMap.put(new MarsPosition(0, 0), "S");

        rover.handle(Arrays.asList(Command.M));
        Assert.assertEquals(new MarsPosition(0, 0), rover.position);
    }
}
