package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class longestSumZero {
    static List<List<Integer>> ans=new ArrayList<>();
    public static List<List<Integer>> allSumZero(int[] arr){
        Arrays.sort(arr);
        helper(arr, arr.length, new ArrayList<>(),0);
        return ans;
    }

    private static void helper(int[] arr, int i, List<Integer> list, int sum) {
        if(i==0){
            if(sum==0 && list.size()!=0){
                ans.add(list);
            }
            return;
        }
        helper(arr, i-1, new ArrayList<>(list),sum);
        list.add(arr[i-1]);
        helper(arr, i-1, new ArrayList<>(list), sum+arr[i-1]);
    }

    public static void main(String[] args) {
        int[] arr={1,-1,0,0,1};
        List<List<Integer>> ans=allSumZero(arr);
        for(List<Integer> i:ans){
            System.out.println(i);
        }
    }
}
