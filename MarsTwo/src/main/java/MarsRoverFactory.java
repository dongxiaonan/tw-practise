import Model.*;
import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class MarsRoverFactory {
    public Map<MarsPosition, String> marsMap;
    public MarsRadar marsRadar;

    public MarsRover init(MarsPosition marsPosition, MarsDirection direction) {
        MarsRover marsRover = new MarsRover(marsPosition, direction, RoverWorkStatus.Forward, marsRadar);
        MarsRover.map = marsMap;
        return marsRover;
    }
}
