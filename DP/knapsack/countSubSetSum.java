package DP.knapsack;

public class countSubSetSum {
    public static void main(String[] args) {
        int[] arr={2,3,5,6,8,10};
        int sum=10;

        int[][] dp=new int[arr.length+1][sum+1];
        for(int i=0; i<dp.length; i++){
            dp[i][0]=1;
        }

        for(int i=1; i<dp.length; i++){
            for(int j = 1; j <dp[i].length;j++){
                if(arr[i-1]<=j){
                    dp[i][j]=dp[i-1][j-arr[i-1]]+dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        System.out.println(dp[arr.length][sum]);
    }
}
