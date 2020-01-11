package TW.FizzBuzzWhizz;

import org.junit.jupiter.api.Test;

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
}