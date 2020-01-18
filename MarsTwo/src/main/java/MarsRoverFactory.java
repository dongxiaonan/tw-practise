import Model.*;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Map;

@AllArgsConstructor
public class MarsRoverFactory {
    public Map<MarsPosition, String> marsMap;
    public MarsRadar marsRadar;

    public MarsRover init(MarsPosition marsPosition, MarsDirection direction, CarType carType) {
        MarsRover marsRover = new MarsRover(marsPosition, direction, RoverWorkStatus.Forward, marsRadar, carType, new ArrayList<>());
        MarsRover.map = marsMap;
        return marsRover;
    }
}
