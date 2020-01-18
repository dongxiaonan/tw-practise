package Model;

import Command.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode
@AllArgsConstructor
public class MarsRover {
    public MarsPosition position;
    public MarsDirection facing;
    public RoverWorkStatus workStatus;

    public void handle(List<Command> commands) {
        for (Command command : commands) {
            switch (command){
                case M -> new MoveCommandHandler().execute(this);
                case B -> new BackCommandHandler().execute(this);
                case L , R -> new TurnCommandHandler(command).execute(this);
            }

        }
    }
}
