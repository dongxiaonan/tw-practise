package TW.YuanyinPractise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class YuanyinTest {
    @ParameterizedTest
    @CsvSource({
            "a, true",
            "e, true",
            "i, true",
            "o, true",
            "u, true"
    })
    public void ShouldReturnIsYuanyin(char letter, boolean expected){
        Assertions.assertEquals(expected, YuanyinPractise.IsYuanyin(letter));
    }
}
