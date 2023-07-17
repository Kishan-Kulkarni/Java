package Recursion;

import java.util.Arrays;

public class selectionSortRecursion {
    public static void main(String[] args) {
        int[] arr={1,4,8,3,7,2};
        sort(arr,arr.length-1,0,0);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int i, int j, int max) {
        if(i==0){
            return;
        }

        max=findMax(arr, i);

        if(j<i){
            int temp=arr[i];
            arr[i]=arr[max];
            arr[max]=temp;
            sort(arr, i, j+1, max);
        }else{
            sort(arr, i-1, 0, max);
        }
        
    }

    private static int findMax(int[] arr, int i) {
        int max=0;
        for(int j=0; j<=i; j++){
            if(arr[j]>arr[max]){
                max=j;
            }
        }
        return max;
    }
}
