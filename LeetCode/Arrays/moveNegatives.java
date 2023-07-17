package LeetCode.Arrays;

import java.util.Arrays;

public class moveNegatives {
    public static void main(String[] args) {
        int[] arr={-1,20,-3,1,2,-1,11,16,-10,13};
        partitionArray(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void partitionArray(int[] arr){
        int s=0;
        int e= arr.length-1;
        while(s<e){
            if(arr[s]>=0){
                int t=arr[s];
                arr[s]=arr[e];
                arr[e]=t;
                e--;
            }else{
                s++;
            }
        }
    }
}
