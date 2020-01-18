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

    public void handle(List<Command> commands) {
        for (Command command : commands) {
            switch (command){
                case M -> new MoveCommandHandler().execute(this);
            }

        }
    }
}
