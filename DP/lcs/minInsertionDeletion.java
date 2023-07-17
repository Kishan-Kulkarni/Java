package DP.lcs;

import java.util.Arrays;

public class minInsertionDeletion {
    public static void main(String[] args) {
        String a="heap";
        String b="pea";
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

        int r=dp.length-1;
        int c=dp[0].length-1;
        StringBuilder ans =new StringBuilder();
        while(r>0 && c>0){
            if(a.charAt(r-1)==b.charAt(c-1)){
                ans.append(a.charAt(r-1));
                r--;
                c--;
            }else{
                if(dp[r-1][c]>dp[r][c-1]){
                    r--;
                }else{
                    c--;
                }
            }
        }

        System.out.println(ans.reverse());
        System.out.println("Deletions:" + (a.length()- ans.length()));
        System.out.println("Insertions" + (b.length()- ans.length()));
    }
}
