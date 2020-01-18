package Model;

import java.util.Random;

public class MarsRadar {
    public boolean isInHole() {
        return new Random().nextBoolean();
    }

    public CarPart brokenPart() {
        int pick = new Random().nextInt(CarPart.values().length);
        return CarPart.values()[pick];
    }
}
