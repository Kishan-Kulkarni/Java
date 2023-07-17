package DP.mcm;

import java.util.Arrays;
import java.util.Objects;

public class palindromePartition {
    static int[][] t;
    public static void main(String[] args) {
        String s="dnitinc";
        int i=0;
        int j=s.length()-1;
        t=new int[s.length()+1][s.length()+1];
        for(int[] r:t){
            Arrays.fill(r, -1);
        }
        System.out.println(countPartitions(s,i,j));
    }

    private static int countPartitions(String s, int i, int j) {
        if(i>=j){
            return t[i][j]=0;
        }

        if(t[i][j]!=-1){
            return t[i][j];
        }

        if(validPartition(s,i,j)){
            return t[i][j]=0;
        }

        int min =s.length()-1;
        for(int k=i;k<=j-1; k++){
            int temp=1;
            if(t[i][k]!=-1){
                temp+=t[i][k];
            }else{
                temp+=countPartitions(s,i,k);
            }

            if(t[k+1][j]!=-1){
                temp+=t[k+1][j];
            }else{
                temp+=countPartitions(s,k+1,j );
            }

            min=Math.min(min, temp);
        }

        return t[i][j]=min;
    }

    private static boolean validPartition(String s, int i, int k) {
        StringBuilder rev=new StringBuilder(s.substring(i,k+1)).reverse();
        return Objects.equals(s.substring(i, k + 1), rev.toString());
    }
}
