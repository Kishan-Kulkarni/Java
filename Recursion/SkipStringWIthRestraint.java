package Recursion;

public class SkipStringWIthRestraint {
    public static void main(String[] args) {
        String a="bananaappleappgrapesappfruits";
        System.out.println(skipAppwhenNotApple(a));
    }

    private static String skipAppwhenNotApple(String a) {
        if(a.isEmpty()){
            return "";
        }

        if(a.startsWith("app")){
            if(a.startsWith("apple")){
                return a.charAt(0) +skipAppwhenNotApple(a.substring(1));
            }else{
                return skipAppwhenNotApple(a.substring(3));
            }
        }else{
            return a.charAt(0) +skipAppwhenNotApple(a.substring(1));
        }
    }
}
