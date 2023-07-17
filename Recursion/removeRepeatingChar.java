package Recursion;

public class removeRepeatingChar {
    public static void main(String[] args) {
        String s="geeksforgeeks";
        System.out.println(trim(s, ""));
    }

    private static String trim(String up, String p) {
        if(up.length()==1){
            return p+up.charAt(0);
        }

        
        if(up.charAt(0)==up.charAt(1)){
            return trim(up.substring(1), p);
        }else{
            return trim(up.substring(1), p+up.charAt(0));
        }
        
    }
}
