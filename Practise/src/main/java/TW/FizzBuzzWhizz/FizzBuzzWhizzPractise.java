package TW.FizzBuzzWhizz;

public class FizzBuzzWhizzPractise {
    public static void main(String[] args) {
        int n = 120;

        for( int i = 0; i < n; i++) {
            String result = fizzBuzz(i+1);
            System.out.println(result);
        }
    }

    public static String fizzBuzz(int i) {
        String output = "";
        if (i%3 == 0){
            output += "Fizz";
        }

        if (i%5 == 0){
            output += "Buzz";
        }
        return output;
    }
}
