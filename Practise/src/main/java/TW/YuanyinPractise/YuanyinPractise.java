package TW.YuanyinPractise;

import java.util.ArrayList;

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
        int yuanyinLength = 0;
        for (int i = 0; i < str.length() ; i = i+1){
            if (IsYuanyin(str.charAt(i))){
                yuanyinLength++;
            }
        }

        return (float)yuanyinLength / str.length() > 0.3;
    }
}
