import java.util.*;

public class SB_Strings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.close();
        String input = sc.next();
        StringBuilder sb = new StringBuilder(input);
        String result = "";
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == 'e') {
                result += "i";
            } else {
                result += sb.charAt(i);
            }
        }
        System.out.println(result);
    }
}
