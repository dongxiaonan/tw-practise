import Command.Command;
import Model.MarsDirection;
import Model.MarsPosition;
import Model.MarsRover;
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
    }

    @Test
    public void should_move_when_get_M_command(){
        rover.handle(Arrays.asList(Command.M));
        Assert.assertEquals(new MarsPosition(0, 0), rover.position);
    }
}
