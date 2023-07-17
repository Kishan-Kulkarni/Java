package DP.lcs;

import java.util.Arrays;

public class lcsubstring {
    static int[][] t;
    public static void main(String[] args) {
        String a="abcde";
        String b="abfce";

        t=new int[a.length()+1][b.length() + 1];
        for(int[] rows:t){
            Arrays.fill(rows,-1);
        }

        System.out.println(longestSubString(a,b,a.length(),b.length(),0));
        for(int[] r:t){
            System.out.println(Arrays.toString(r));
        }
        System.out.println();

        int max=0;
        int[][] dp=new int[a.length() + 1][b.length()+1];
        for(int i=1; i<dp.length; i++){
            for(int j = 1; j< dp[0].length; j++){
                char one=a.charAt(i-1);
                char two = b.charAt(j-1);
                if(one == two){
                    dp[i][j]=1+dp[i-1][j-1];
                    if(dp[i][j]>max){
                        max=dp[i][j];
                    }
                }else{
                    dp[i][j]=0;
                }
            }
        }

        for(int[] r:dp){
            System.out.println(Arrays.toString(r));
        }
        System.out.println(max);
    }

    private static int longestSubString(String a, String b, int n, int m, int res) {
        if(n==0 || m==0){
            return t[n][m]=res;
        }

        if(a.charAt(n-1)==b.charAt(m-1)){
            res=longestSubString(a,b,n-1,m-1,res+1);
            t[n][m]=res;
        }

        return t[n][m]=Math.max(res, Math.max(longestSubString(a,b,n-1,m,0), longestSubString(a,b,n,m-1,0)));
    }
}
