package Recursion;

public class skipStringRecursion {
    public static void main(String[] args) {
        String a = "applebananagrapesmelon";
        //To check if the string is starting with apple, use the inbuilt function of a.startsWith("apple")
        System.out.println(skipApple(a));
    }

    private static String skipApple(String a) {
        if (a.isEmpty()) {
            return "";
        }

        char ch = a.charAt(0);
        if (a.length() > 4) {
            if (ch == 'a') {
                if ((a.substring(0, 5)).equals("apple")) {
                    return skipApple(a.substring(5));
                } else {
                    return ch+skipApple(a.substring(1));
                }
            } else {
                return ch + skipApple(a.substring(1));
            }
        } else {
            return a;
        }
    }
}
