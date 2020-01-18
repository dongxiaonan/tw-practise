package CommandHandler;

import Model.*;

import java.util.List;

public class TurnCommandHandler extends BaseCommandHandler{

    public TurnCommandHandler(Command turnCommand) {
        super(turnCommand);
    }

    @Override
    public void execute(MarsRover rover) {
        int turn = rover.workStatus == RoverWorkStatus.Forward  ^ command == Command.R ? -1 : 1;

        if (canTurn(turn, rover.brokenParts)){
            return;
        }

        MarsDirection[] allDirections = MarsDirection.values();
        int directionLength = allDirections.length;
        int newDirectionIndex = (directionLength + rover.facing.ordinal() + turn) % directionLength;
        rover.facing = allDirections[newDirectionIndex];
    }

    private boolean canTurn(int turn, List<CarPart> brokenParts) {
        return (brokenParts.contains(CarPart.LEFTWHEEL) && turn == -1) || (brokenParts.contains(CarPart.RIGHTWHEEL) && turn == 1);
    }
}
