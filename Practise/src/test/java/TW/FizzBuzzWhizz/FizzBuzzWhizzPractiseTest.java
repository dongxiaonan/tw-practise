package TW.FizzBuzzWhizz;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzWhizzPractiseTest {
    @Test
    public void ShouldReturnFizzWhenCanDividedByThree(){
        assertEquals("Fizz", FizzBuzzWhizzPractise.fizzBuzz(9));
    }

    @Test
    public void ShouldReturnBuzzWhenCanDividedByFive(){
        assertEquals("Buzz", FizzBuzzWhizzPractise.fizzBuzz(5));
    }

    @Test
    public void ShouldReturnWihzzWhenCanDividedBySeven(){
        assertEquals("Wihzz", FizzBuzzWhizzPractise.fizzBuzz(7));
    }

    @ParameterizedTest
    @CsvSource({
            "21, FizzWihzz", "60, FizzBuzz", "140, BuzzWihzz", "210, FizzBuzzWihzz"
    })
    public void ShouldReturnCombinedStringWhenCanDividedByMoreThanOnNumber(int input, String expected){
        assertEquals(expected, FizzBuzzWhizzPractise.fizzBuzz(input));
    }

    @Test
    public void ShouldReturnNumberWhenNotMatchAnyRule(){
        assertEquals("1", FizzBuzzWhizzPractise.fizzBuzz(1));
    }
}