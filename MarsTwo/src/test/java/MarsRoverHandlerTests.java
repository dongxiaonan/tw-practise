import Command.Command;
import Model.MarsDirection;
import Model.MarsPosition;
import Model.MarsRover;
import Model.RoverWorkStatus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class MarsRoverHandlerTests {
    private Map<MarsPosition, String> marsMap = new HashMap<>();
    private MarsRover rover;

    @Before
    public void setup(){
        MarsPosition marsPosition = new MarsPosition(0, 0);
        rover = MarsRoverFactory.init(marsPosition, MarsDirection.N);
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
}
