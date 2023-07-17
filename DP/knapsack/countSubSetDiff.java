package DP.knapsack;

import java.util.Arrays;

public class countSubSetDiff {
    public static void main(String[] args) {
        int[] arr={0,0,0,0,0,0,0,0,1};
            int diff=1;
            int sum=(Arrays.stream(arr).sum()+diff)/2;


            int[][] dp=new int[arr.length+1][sum+1];
            for(int i=0; i<dp.length; i++){
                dp[i][0]=1;
            }

            for(int i=1; i<dp.length; i++){
                for(int j = 0; j <dp[i].length;j++){
                    if(arr[i-1]<=j){
                        dp[i][j]=dp[i-1][j-arr[i-1]]+dp[i-1][j];
                    }else{
                        dp[i][j]=dp[i-1][j];
                    }
                }
            }

        System.out.println(dp[arr.length][sum]);
        for(int[] i:dp){
            System.out.println(Arrays.toString(i));
        }
    }
}
