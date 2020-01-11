package TW.YuanyinPractise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class YuanyinTest {
    @ParameterizedTest
    @CsvSource({
            "hmm, false", "abc, true", "ab, true"
    })
    public void ShouldReturnCanReplace(String str, boolean expected){
        Assertions.assertEquals(expected, YuanyinPractise.CanReplace(str));
    }

    @ParameterizedTest
    @CsvSource({
            "hmm, hmm", "she, shmommy", "hear, hmommyr", "Oppo, mommyppmommy"
    })
    public void ShouldReplaceYuanyin(String input, String expected){
        Assertions.assertEquals(expected, YuanyinPractise.Handle(input));
    }

    @Test
    public void ShouldNotHandleWhenInputInvalid(){
        Assertions.assertEquals(null, YuanyinPractise.Handle(null));
        Assertions.assertEquals("", YuanyinPractise.Handle(""));
    }
}
