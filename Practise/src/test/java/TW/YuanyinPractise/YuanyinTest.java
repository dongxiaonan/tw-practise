package TW.YuanyinPractise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class YuanyinTest {
    @ParameterizedTest
    @CsvSource({
            "a, true",
            "e, true",
            "i, true",
            "o, true",
            "u, true",
            "A, true",
            "x, false",
            "0, false",
            "&, false"
    })
    public void ShouldReturnIsYuanyin(char letter, boolean expected){
        Assertions.assertEquals(expected, YuanyinPractise.IsYuanyin(letter));
    }
}
