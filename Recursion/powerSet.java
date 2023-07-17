package Recursion;

import java.util.ArrayList;
import java.util.Collections;

public class powerSet {
    public static void main(String[] args) {
        String s ="nitin";
        ArrayList<String> list=allPermutations(s,"");
        Collections.sort(list);
        list.remove("");
        System.out.println(list);
    }

    private static ArrayList<String> allPermutations(String s, String ans) {
        if(s.isEmpty()){
            ArrayList<String> list=new ArrayList<>();
            list.add(ans);
            return list;
        }

        char ch=s.charAt(0);
        ArrayList<String> first=allPermutations(s.substring(1), ans+ch);
        ArrayList<String> second=allPermutations(s.substring(1), ans);

        first.addAll(second);

        return first;
    }
}
