package Recursion;

public class skipCharRecursion {
    public static void main(String[] args) {
        String a="baccadh";
        System.out.println(a);
        System.out.println(skipA(a));
    }

    private static String skipA(String a) {
        if(a.isEmpty()){
            return "";
        }

        char ch=a.charAt(0);

        if(ch=='a'){
            return skipA(a.substring(1));
        }else{
            return ch+skipA(a.substring(1));
        }
    }

   
}
