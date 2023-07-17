package DP.unbounded;

import java.util.Arrays;

public class coinSumWays {
    static int[][] t=new int[10][10];
    public static void main(String[] args) {
        int[] coins={1,2,3,5};
        int sum =5;
        int[][] memo=new int[coins.length+1][sum+1];

        for(int j=1;j<t.length; j++){
            t[j][0]=1;
        }



        for(int j=1;j<memo.length; j++){
            memo[j][0]=1;
        }



        for(int i=1; i<t.length; i++){
            for (int j = 1; j < t[i].length; j++) {
                t[i][j]=-1;
            }
        }

        for(int i=1; i<=coins.length; i++){
            for(int j=1; j<=sum; j++){
                if(j>=coins[i-1]){
                    memo[i][j]=memo[i][j-coins[i-1]]+memo[i-1][j];
                }else{
                    memo[i][j] = memo[i-1][j];
                }
            }
        }

        System.out.println(printSumWays(coins, sum,coins.length));
        System.out.println(memo[coins.length][sum]);
        for(int[] temp:t){
            System.out.println(Arrays.toString(temp));
        }

        System.out.println();
        for(int[] temp:memo){
            System.out.println(Arrays.toString(temp));
        }

        int min=Integer.MAX_VALUE;

        for(int i=1; i<memo.length; i++){
            if(memo[i][memo[i].length-1]<min){
                min=memo[i][memo[i].length-1];
            }
        }

        System.out.println(min);
    }

    private static int printSumWays(int[] coins, int sum, int n) {

        if(n==0){
            return 0;
        }

        if(sum==0){
            return 1;
        }

        if(coins[n-1]>sum){
            return t[n][sum]=printSumWays(coins, sum, n-1);
        }

        if(t[n][sum]==-1){
            return t[n][sum]=printSumWays(coins, sum-coins[n-1], n)+printSumWays(coins, sum, n-1);
        }else{
            return t[n][sum];
        }
    }
}
