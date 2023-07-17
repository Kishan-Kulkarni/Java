package Recursion;

public class checkParanthesis {
    public static void main(String[] args) {
        String s = "({)}";
        System.out.println(paranthesis(s, 0,s.length()-1));
    }

    private static boolean paranthesis(String s, int a, int b) {
        if (s.isEmpty()) {
            return true;
        }
        

        boolean x;
        boolean y;
        char ch = s.charAt(0);
        int i = search(s, ch);
        if(i==-1){
            return false;
        }
        if (i != s.length() - 1) {
            x = paranthesis(s.substring(0, i+1), 0, i);
            y = paranthesis(s.substring(i+1), i + 1, s.length());
        } else {
            x = paranthesis(s.substring(1, i), 1, i-1);
            y = true;
        }
        return x & y;
    }

    private static int search(String s, char ch) {

        if (ch == '(') {
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == ')') {
                    return j;
                }
            }
        } else if (ch == '[') {
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == ']') {
                    return j;
                }
            }
        } else if(ch=='{'){
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '}') {
                    return j;
                }
            }
        }

        if (ch == ')') {
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '(') {
                    return j;
                }
            }
        } else if (ch == ']') {
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '[') {
                    return j;
                }
            }
        } else if(ch =='}'){
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '{') {
                    return j;
                }
            }
        }

        return -1;
    }

}
