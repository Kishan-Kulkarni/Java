package Recursion;

import java.util.ArrayList;

public class subSetRecursion {
    public static void main(String[] args) {
        String a ="abc";
        printAllSubSets(a, "");
        ArrayList<String> list=new ArrayList<String>();
        list=printAllSubSets1(a, "");
        System.out.println(list);
    }

    private static void printAllSubSets(String a, String b) {
        if(a.isEmpty()){
            System.out.println(b);
            return;
        }

        printAllSubSets(a.substring(1), b+a.charAt(0));
        printAllSubSets(a.substring(1), b);
    }

    private static ArrayList<String> printAllSubSets1(String a, String b) {
        if(a.isEmpty()){
            ArrayList<String> list=new ArrayList<String>();
            list.add(b);
            return list;
        }

        
        ArrayList<String> listFromLeft=printAllSubSets1(a.substring(1), b+a.charAt(0));
        ArrayList<String> listFromRight=printAllSubSets1(a.substring(1), b);
        listFromLeft.addAll(listFromRight);

        return listFromLeft;
    }
}
