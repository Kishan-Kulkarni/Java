package LeetCode.Arrays;

import java.util.Arrays;

public class cyclicRotate {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        rotateByOne(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void rotateByOne(int[] arr){
        for(int i=0; i<arr.length/2; i++){
            int t=arr[i];
            arr[i]=arr[arr.length -1-i];
            arr[arr.length-1-i]=t;
        }
        for(int i=1; i<(arr.length+1)/2; i++){
            int t=arr[i];
            arr[i]=arr[arr.length-i];
            arr[arr.length-i]=t;
        }
    }
}
