package CommandHandler;

import Model.Command;
import Model.MarsPosition;
import Model.MarsRover;
import Model.RoverWorkStatus;

public class MoveCommandHandler extends BaseCommandHandler{

    public MoveCommandHandler() {
        super(Command.M);
    }

    @Override
    public void execute(MarsRover rover) {
        int step = rover.workStatus == RoverWorkStatus.Forward ? 1 : -1;
        MarsPosition gotoPosition = rover.position;
        switch (rover.facing){
            case N -> gotoPosition.y += step;
            case S -> gotoPosition.y -= step;
            case E -> gotoPosition.x += step;
            case W -> gotoPosition.x -= step;
        }

        if (MarsRover.map.containsKey(gotoPosition) && ( MarsRover.map.get(gotoPosition).equals("X") ||  MarsRover.map.get(gotoPosition).equals("S"))){
            return;
        }

        rover.position = gotoPosition;
    }
}
