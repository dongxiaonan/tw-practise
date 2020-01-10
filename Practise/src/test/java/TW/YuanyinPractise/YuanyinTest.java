package TW.YuanyinPractise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class YuanyinTest {
    @Test
    public void ShouldReturnTrueWhenCharIsYuanyin(){
        Assertions.assertTrue(YuanyinPractise.IsYuanyin('a'));
    }
}
