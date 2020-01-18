package Command;

import Model.MarsRover;
import Model.RoverWorkStatus;

public class BackCommandHandler extends BaseCommandHandler{

    public BackCommandHandler() {
        super(Command.B);
    }

    @Override
    public void execute(MarsRover rover) {
        switch (rover.workStatus){
            case Forward -> rover.workStatus = RoverWorkStatus.Backward;
            case Backward -> rover.workStatus = RoverWorkStatus.Forward;
        }
    }
}
