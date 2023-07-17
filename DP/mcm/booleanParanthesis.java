package DP.mcm;

import java.security.KeyStore;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class booleanParanthesis {
    static int[][][] t;
    static HashMap<String,Integer> map=new HashMap<>(); //You can use this instead!!!. Here the String has i, j, isTrue; ex:i=5, j=9, isTrue=false String ="5_9_false"
    public static void main(String[] args) {
        String s="T^F&T";
        t=new int[s.length()+1][s.length()+1][2];
        for(int[][] r:t){
            for(int[] e:r){
                Arrays.fill(e,-1);
            }
        }
        System.out.println(countParanthesis(s,0,s.length()-1,true));
        boolean f=false;
        String e=1+"_" +5+ "_"+ f;
        System.out.println(e);
    }

    private static int countParanthesis(String s, int i, int j, boolean isTrue) {
        if(i>j){
            return t[i][j][isTrue?1:0]=0;
        }

        if(t[i][j][isTrue?1:0]!=-1){
            return t[i][j][isTrue?1:0];
        }

        if(i==j){
            if(isTrue){
                return s.charAt(i)=='T'?1:0;
            }else{
                return s.charAt(i)=='F'?1:0;
            }
        }
        int ans=0;
        for(int k=i+1; k<=j-1; k=k+2){
            int lt;
            int lf;
            int rt;
            int rf;
            if(t[i][k-1][1]!=-1){
                lt=t[i][k-1][1];
            }else{
                lt=countParanthesis(s,i,k-1,true);
            }

            if(t[i][k-1][0]!=-1){
                lf=t[i][k-1][0];
            }else{
                lf=countParanthesis(s,i,k-1,false);
            }

            if(t[k+1][j][1]!=-1){
                rt=t[k+1][j][1];
            }else{
                rt=countParanthesis(s,k+1,j,true);
            }

            if(t[k+1][j][0]!=-1){
                rf=t[k+1][j][0];
            }else{
                rf=countParanthesis(s,k+1,j,false);
            }

            if(s.charAt(k)=='|'){
                if(isTrue){
                    ans+=(lt*rt+lf*rt+rf*lt);
                }else{
                    ans+=(lf*rf);
                }
            }else if(s.charAt(k)=='&'){
                if(isTrue){
                    ans+=(lt*rt);
                }else{
                    ans+=(lf*rf + lt*rf + lf*rt);
                }
            }else if(s.charAt(k)=='^'){
                if(isTrue){
                    ans+=(lt*rf + lf*rt);
                }else{
                    ans+=(lt*rt + lf*rf);
                }
            }
        }
        return t[i][j][isTrue?1:0]=ans;
    }

}
