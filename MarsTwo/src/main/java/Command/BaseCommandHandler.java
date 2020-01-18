package Command;

import Model.MarsRover;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class BaseCommandHandler {
    public Command command;

    abstract public void execute(MarsRover rover);
}
