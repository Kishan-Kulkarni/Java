package Recursion;

import java.util.Arrays;

public class inPlaceMergeSort {

    //Prefered for linked lists quick sorts for arrays, the inbuilt java functions can be used as well
    public static void main(String[] args) {
        int[] arr={5,4,3,2,1};

        sort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr , int s, int e) {
        if(e-s==1){
            return;
        }

        int m=s+(e-s)/2;

        sort(arr, s, m);
        sort(arr, m, e);

        mergeInPlace(arr, s, e, m);
    }

    private static void mergeInPlace(int[] arr, int s, int e, int m) {

        int[] mix= new int[e-s];

        int i=s;
        int j=m;
        int k=0;

        while(i<m && j<e){
            if(arr[i]<arr[j]){
                mix[k]=arr[i];
                i++;
            }else{
                mix[k]=arr[j];
                j++;
            }
            k++;
        }

        while(i<m){
            mix[k]=arr[i];
            i++;
            k++;
            
        }

        while(j<e){
            mix[k]=arr[j];
            j++;
            k++;
            
        }

        for(int l=0; l<mix.length; l++){
            arr[s+l]=mix[l];
        }
    }
}
