package LeetCode.Arrays;

import java.util.ArrayList;

public class unionArrays {
    public static void main(String[] args) {
        System.out.println(union(new int[]{85,25,1,32,54,6}, new int[]{85,2}));
    }
    public static int union(int[] a, int[] b){
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i:a){
            if(!ans.contains(i)){
                ans.add(i);
            }
        }
        for(int i:b){
            if(!ans.contains(i)){
                ans.add(i);
            }
        }
        return ans.size();
    }
}
