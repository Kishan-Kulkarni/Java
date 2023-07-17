package LeetCode;

import java.util.Arrays;

public class findMaxLenStr {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp=new int[m+1][n+1];
        for(String s:strs){
            int ones=findOnes(s);
            int zeros=s.length()-ones;
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i-zeros][j-ones]);
                }
            }
        }
        return dp[m][n];
    }

//    public int helper(String[] strs, int m, int n, int length) {
//        if(length==0){
//            return 0;
//        }
//        if(dp[m][n][length]!=-1){
//            return dp[m][n][length];
//        }
//        int ones=findOnes(strs[length-1]);
//        int zeros=findZeros(strs[length-1]);
//
//        if(ones>n || zeros>m){
//            return dp[m][n][length]=helper(strs, m,n,length-1 );
//        }
//
//        return dp[m][n][length]=Math.max(helper(strs,m-zeros,n-ones, length-1)+1, helper(strs, m,n,length-1 ));
//    }


    private int findOnes(String str) {
        int ans=0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) =='1'){
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new findMaxLenStr().findMaxForm(new String[]{"10", "1", "0","0001", "111001"},5,3));
    }
}
