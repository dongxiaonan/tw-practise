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

        if (canTurn(turn, rover.brokenParts, rover)){
            return;
        }

        MarsDirection[] allDirections = MarsDirection.values();
        int directionLength = allDirections.length;
        int newDirectionIndex = (directionLength + rover.facing.ordinal() + turn) % directionLength;
        rover.facing = allDirections[newDirectionIndex];
    }

    private static boolean canTurn(int turn, List<CarPart> brokenParts, MarsRover rover) {
        boolean canTurnWhenNotBreak = (brokenParts.contains(CarPart.LEFTWHEEL) && turn == -1) || (brokenParts.contains(CarPart.RIGHTWHEEL) && turn == 1);

        if (rover.carType == CarType.DEFAULT ){
            return canTurnWhenNotBreak;
        }

        boolean canTurnWhenHasEnoughSpace = !rover.map.get(rover.position).equals("X") &&  !rover.map.get(rover.getCarTailPosition()).equals("X");
        return canTurnWhenNotBreak && canTurnWhenHasEnoughSpace;
    }

}
