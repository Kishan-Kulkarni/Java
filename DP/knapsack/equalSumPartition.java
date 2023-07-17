package DP.knapsack;

import java.util.Arrays;

public class equalSumPartition {
    public static void main(String[] args) {
        int[] arr={1,5,11,5,6};
        int sum= Arrays.stream(arr).sum();
        int target= sum >> 1;

        boolean[][] dp =new boolean[arr.length+1][target+1];
        for(int i=0; i<dp.length; i++){
            dp[i][0]=true;
        }

        for(int i=1; i<dp.length; i++){
            for(int j = 1; j< dp[0].length; j++){
                if(arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        for (boolean[] bools : dp) {
            System.out.println(Arrays.toString(bools));
        }

        System.out.println();
        System.out.println(dp[arr.length][target]);
    }
}
