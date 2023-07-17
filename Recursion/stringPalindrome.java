package Recursion;

import java.util.ArrayList;

public class stringPalindrome {
    public static void main(String[] args) {
        String s="nitin";
        printPalindrome(s,"");
        System.out.println();
        System.out.println(listPalindrome(s, ""));
    }

    private static void printPalindrome(String s, String p) {
        if(s.isEmpty()){
            if(isPalindrome(p)){
                System.out.println(p);
                return;
            }
            return;
        }

        char ch=s.charAt(0);
        printPalindrome(s.substring(1), p+ch);
        printPalindrome(s.substring(1), p);
    }

    private static boolean isPalindrome(String p) {
        boolean isPal=true;
        for(int i=0; i<p.length()/2; i++){
            char f=p.charAt(i);
            char b=p.charAt(p.length()-i-1);
            if(f!=b){
                isPal=false;
                break;
            }
        }
        return isPal;
    }

    private static ArrayList<String> listPalindrome(String s, String p){
        if(s.isEmpty()){
            if(isPalindrome(p)){
                ArrayList<String> list=new ArrayList<>();
                list.add(p);
                return list;
            }
            return new ArrayList<>();
        }

        char ch=s.charAt(0);

        ArrayList<String> list1=listPalindrome(s.substring(1), p+ch);
        ArrayList<String> list2=listPalindrome(s.substring(1), p);

        list1.addAll(list2);

        return list1;
    }
}
