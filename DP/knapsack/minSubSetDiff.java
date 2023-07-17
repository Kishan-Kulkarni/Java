package DP.knapsack;

import java.util.Arrays;

public class minSubSetDiff {
    public static void main(String[] args) {
        int[] arr={1,6,11,5};
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

        for(int i=dp[0].length-1; i>=0; i--){
            if(dp[arr.length][i]){
                System.out.println(Math.abs(sum-2*i));
                break;
            }
        }
    }
}
