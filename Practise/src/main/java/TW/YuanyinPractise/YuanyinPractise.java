package TW.YuanyinPractise;

import java.util.ArrayList;
import java.util.stream.Stream;

public class YuanyinPractise {
    public static boolean IsYuanyin(char a) {
        ArrayList<Character> yuanyinChars = new ArrayList<>();
        yuanyinChars.add('a');
        yuanyinChars.add('A');
        yuanyinChars.add('e');
        yuanyinChars.add('E');
        yuanyinChars.add('i');
        yuanyinChars.add('I');
        yuanyinChars.add('o');
        yuanyinChars.add('O');
        yuanyinChars.add('u');
        yuanyinChars.add('U');

        return yuanyinChars.contains(a);
    }

    public static boolean CanReplace(String str) {
        Stream<Character> characterStream = str.chars().mapToObj(i -> (char) i);
        float count = characterStream.filter(YuanyinPractise::IsYuanyin).count();

        return count / str.length() > 0.3;
    }

    public static String Handle(String input) {
        if (CanReplace(input)){
            return null;
        }
        return input;
    }
}
