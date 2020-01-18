package Model;

import CommandHandler.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import javax.management.openmbean.TabularData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@EqualsAndHashCode
@AllArgsConstructor
public class MarsRover {
    public MarsPosition position;
    public MarsDirection facing;
    public RoverWorkStatus workStatus;
    public MarsRadar marsRadar;
    public CarType carType;
    public List<CarPart> brokenParts;

    public static Map<MarsPosition, String> map;

    public void handle(List<Command> commands) {
        for (Command command : commands) {
            switch (command){
                case M -> new MoveCommandHandler().execute(this);
                case B -> new BackCommandHandler().execute(this);
                case L , R -> new TurnCommandHandler(command).execute(this);
            }
        scan();
        }
    }

    public  MarsPosition getCarTailPosition() {
        MarsPosition carTailPosition = position;
        switch (facing){
            case N -> carTailPosition.y --;
            case S -> carTailPosition.y ++;
            case E -> carTailPosition.x --;
            case W -> carTailPosition.x ++;
        }
        return carTailPosition;
    }

    private void scan() {
        if (marsRadar.isInHole()){
            map.put(position, "X");
        }
    }

    private void healthCheck() {
        CarPart brokenPart = marsRadar.brokenPart();
        if (!brokenParts.contains(brokenPart)){
            brokenParts.add(brokenPart);
        }
    }
}
