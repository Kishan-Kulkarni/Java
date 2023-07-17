package Recursion;


public class lengthOfString {
    public static void main(String[] args) {
        int ans=length("abcd");
        System.out.println(ans);
    }

    private static int length(String string) {
        return helper(string, 0);//Instead of using this helper "return length(string.substring(1)) +1" can be used and in the if statement return 0
    }

    private static int helper(String string, int i) {
        if(string.isEmpty()){
            return i;
        }

        return helper(string.substring(1), i+1);
    }
}
