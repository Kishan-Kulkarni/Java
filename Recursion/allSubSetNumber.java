package Recursion;

import java.util.ArrayList;

public class allSubSetNumber {
    public static void main(String[] args) {
        int n=4;
        System.out.println(allPerms(n, new ArrayList<ArrayList<Integer>>()));
    }

    private static ArrayList<ArrayList<Integer>> allPerms(int n, ArrayList<ArrayList<Integer>> list) {
        if(n==0){
            return list;
        }

        list.add(new ArrayList<>());
        
        
        return null;
    }
}
