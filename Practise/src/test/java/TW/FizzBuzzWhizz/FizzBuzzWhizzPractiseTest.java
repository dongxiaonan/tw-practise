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
    public void ShouldReturnWhizzWhenCanDividedBySeven(){
        assertEquals("Whizz", FizzBuzzWhizzPractise.fizzBuzz(7));
    }

    @ParameterizedTest
    @CsvSource({
            "21, FizzWhizz", "60, FizzBuzz", "140, BuzzWhizz", "210, FizzBuzzWhizz"
    })
    public void ShouldReturnCombinedStringWhenCanDividedByMoreThanOnNumber(int input, String expected){
        assertEquals(expected, FizzBuzzWhizzPractise.fizzBuzz(input));
    }

    @Test
    public void ShouldReturnNumberWhenNotMatchAnyRule(){
        assertEquals("1", FizzBuzzWhizzPractise.fizzBuzz(1));
    }
}