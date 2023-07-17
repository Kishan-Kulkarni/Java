package Recursion;

public class removeAllRepeating {
    public static void main(String[] args) {
        String S="geeksforgeeks";
        System.out.println(uniqueString(S,new String(), ' '));
    }

    private static String uniqueString(String S, String p,  char c) {
        if(S.isEmpty()){
            return p;
        }

        char ch=S.charAt(0);

        if(c==S.charAt(0)){
            return uniqueString(S.substring(1), p, ch);
        }else{
            return uniqueString(S.substring(1), p+ch,  ch);
        }

    }
}
