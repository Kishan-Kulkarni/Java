package Recursion;

import java.util.ArrayList;

public class combinationSum {

    public static ArrayList<ArrayList<Integer>> combiSum(int arr[] , int target){
        ArrayList<ArrayList<Integer>> list= new ArrayList<>();
        if(target==0){
            ArrayList<Integer> x= new ArrayList<>();
            x.add(0);
            list.add(x);
            return list;
        }

        if(target<0){
            return list;
        }

        for(int n: arr){
            int remainder= target-n;
            ArrayList<ArrayList<Integer>> answerFromBelowCalls= combiSum(arr, remainder);
            list.addAll(answerFromBelowCalls);
        }

        return list;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> answer=combiSum(new int[]{1,2,3}, 7);
        System.out.println(answer);
    }
}
