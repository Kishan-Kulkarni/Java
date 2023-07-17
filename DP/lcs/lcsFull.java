package DP.lcs;

import java.util.Arrays;

public class lcsFull {
    static int[][] t;
    public static void main(String[] args) {
        String a="abcdaf";
        String b="acbcf";
        t=new int[a.length()+1][b.length() + 1];
        for(int[] rows:t){
            Arrays.fill(rows,-1);
        }
        System.out.println(lcsLength(a,b,a.length(),b.length()));

        int[][] dp=new int[a.length() + 1][b.length()+1];
        for(int i=1; i<dp.length; i++){
            for(int j = 1; j< dp[0].length; j++){
                char one=a.charAt(i-1);
                char two = b.charAt(j-1);
                if(one == two){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        for(int[] r:dp){
            System.out.println(Arrays.toString(r));
        }
        System.out.println();
        for(int[] r:t){
            System.out.println(Arrays.toString(r));
        }
    }

    private static int lcsLength(String a, String b, int n, int m) {
        if(n<=0 || m<=0){
            return t[n][m]=0;
        }

        if(t[n][m]!=-1){
            return t[n][m];
        }

        if(a.charAt(n-1)==b.charAt(m-1)){
            return t[n][m]=1+lcsLength(a,b,n-1,m-1);
        }else{
            return t[n][m]=Math.max(lcsLength(a,b,n-1,m),lcsLength(a,b,n,m-1));
        }
    }
}
