package Command;

import Model.MarsDirection;
import Model.MarsRover;
import Model.RoverWorkStatus;

public class TurnCommandHandler extends BaseCommandHandler{

    public TurnCommandHandler(Command turnCommand) {
        super(turnCommand);
    }

    @Override
    public void execute(MarsRover rover) {
        int turn = rover.workStatus == RoverWorkStatus.Forward  ^ command == Command.R ? -1 : 1;

        MarsDirection[] allDirections = MarsDirection.values();
        int directionLength = allDirections.length;
        int newDirectionIndex = (directionLength + rover.facing.ordinal() + turn) % directionLength;
        rover.facing = allDirections[newDirectionIndex];
    }
}
