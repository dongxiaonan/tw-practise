package Command;

import Model.MarsRover;
import Model.RoverWorkStatus;

public class MoveCommandHandler extends BaseCommandHandler{

    public MoveCommandHandler() {
        super(Command.M);
    }

    @Override
    public void execute(MarsRover rover) {
        int step = rover.workStatus == RoverWorkStatus.Forward ? 1 : -1;
        switch (rover.facing){
            case N -> rover.position.y += step;
            case S -> rover.position.y -= step;
            case E -> rover.position.x += step;
            case W -> rover.position.x -= step;
        }
    }
}
