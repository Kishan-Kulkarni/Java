package DP.unbounded;

import java.util.Arrays;

public class rodCutting {
    public static void main(String[] args) {
        int[] length=new int[]{1,2,3,4,5,6,7,8};
        int[] prices=new int[]{1,5,8,9,10,17,17,20};
        int N=8;
        int n=length.length;
        int[][] dp=new int[n+1][N+1];
        for(int i=1; i<dp.length; i++){
            for (int j = 1; j < dp[0].length; j++) {
                if(length[i-1]<=j){
                    dp[i][j]=Math.max(dp[i][j-length[i-1]]+prices[i-1], dp[i-1][j]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        for(int[] i:dp){
            System.out.println(Arrays.toString(i));
        }
    }
}
