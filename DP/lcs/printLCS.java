package DP.lcs;

import java.util.Arrays;

public class printLCS {
    public static void main(String[] args) {
        String a="abcdef";
        String b="abfcef";
        //Do not do this, instead use the original dp matrix of lcs and start from the last element and check if they are equal, if they are move diagonally
        //if not choose the max of neighbours and move there till you reach first row or column. Check DP.lcs.lcSuperSeq
        StringBuilder[][] dp=new StringBuilder[a.length() + 1][b.length()+1];
        for(StringBuilder[] r:dp){
            Arrays.fill(r,new StringBuilder(""));
        }
        for(int i=1; i<dp.length; i++){
            for(int j = 1; j< dp[0].length; j++){
                char one=a.charAt(i-1);
                char two = b.charAt(j-1);
                if(one == two){
                    dp[i][j]=new StringBuilder(dp[i-1][j-1]).append(one);
                }else{
                    if(dp[i-1][j].length()>dp[i][j-1].length()){
                        dp[i][j]=dp[i-1][j];
                    }else{
                        dp[i][j]=dp[i][j-1];
                    }
                }
            }
        }

        for(StringBuilder[] r:dp){
            System.out.println(Arrays.toString(r));
        }
    }
}
