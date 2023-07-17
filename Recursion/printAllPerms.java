package Recursion;

import java.util.ArrayList;
import java.util.Collections;

public class printAllPerms {
    public static void main(String[] args) {
        String str="abc";
        String p="";
        System.out.println(allPerms(str, p));
        ArrayList<String> list=allPerms(str, p);
        Collections.sort(list);
        System.out.println(list);
    }

    private static ArrayList<String> allPerms(String str, String p) {
        if(str.isEmpty()){
            ArrayList<String> list= new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> ans=new ArrayList<>();

        ArrayList<String> ansLeft=allPerms(str.substring(1), p+str.charAt(0));
        ArrayList<String> ansRight=allPerms(str.substring(1), p);

        ansLeft.addAll(ansRight);
        ans.addAll(ansLeft);

        return ans;
    }
}
