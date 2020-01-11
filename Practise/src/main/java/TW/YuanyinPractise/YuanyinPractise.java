package TW.YuanyinPractise;

public class YuanyinPractise {
    public static boolean CanReplace(String str) {
        if (str == null){
            return false;
        }

        String yuanyinString = str.replaceAll("(?i)[^aeiou]+", "");
        return (float)yuanyinString.length() / str.length() > 0.3;
    }

    public static String Handle(String input) {
        if (CanReplace(input)){
            return input.replaceAll("(?i)[aeiou]+", "mommy");
        }
        return input;
    }
}
