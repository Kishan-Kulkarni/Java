package DP.mcm;

import java.util.Arrays;

public class mcmfull {
static int[][] t;
    public static void main(String[] args) {
        int[] arr=new int[]{40,20,30,10,30};
        int i=1;
        int j=arr.length - 1;
        t=new int[arr.length+1][arr.length+1];
        for(int[] r:t){
            Arrays.fill(r, -1);
        }
        System.out.println(minProductCost(arr, i ,j));
    }

    private static int minProductCost(int[] arr, int i, int j) {
        if(i>=j){
            return t[i][j]=0;
        }

        if(t[i][j]!=-1){
            return t[i][j];
        }

        int min=Integer.MAX_VALUE;
        for(int k=i; k<=j-1; k++){
            int temp=minProductCost(arr,i, k)+minProductCost(arr, k+1, j)+ arr[i-1]*arr[k]*arr[j];
            min=Math.min(min,temp);
        }

        return t[i][j]=min;
    }
}
