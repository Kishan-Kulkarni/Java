package DP.lcs;

import java.util.Arrays;

public class longestRepeatingSeq {
    public static void main(String[] args) {
        String a="aabebcdd";
        String b=new String(a);
        int[][] dp=new int[a.length() + 1][b.length()+1];
        for(int i=1; i<dp.length; i++){
            for(int j = 1; j< dp[0].length; j++){
                char one=a.charAt(i-1);
                char two = b.charAt(j-1);
                if(one == two && i!=j){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        for(int[] r:dp){
            System.out.println(Arrays.toString(r));
        }
    }
}
