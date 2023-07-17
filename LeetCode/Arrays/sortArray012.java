package LeetCode.Arrays;

import java.util.Arrays;

public class sortArray012 {
    public static void main(String[] args) {
        int[] arr={0,2,0,2,0,0};
        sort012(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort012(int[] arr){
        int zero=0;
        int one=0;
        for(int i:arr){
            if(i==0) zero++;
            if(i==1) one++;
        }
        for(int i=0; i<zero; i++){
            arr[i]=0;
        }
        for (int i = zero; i < one+zero; i++) {
            arr[i]=1;
        }
        for(int i=one+zero; i<arr.length;i++){
            arr[i]=2;
        }
    }
}
