package Recursion;

import java.util.Arrays;

public class mergeSort {
    public static void main(String[] args) {
        int[] arr={8,3,4,12,5,6};
        System.out.println(Arrays.toString(sort(arr)));

    }

    static int[] sort(int[] arr){
        if(arr.length==1){
            return arr;
        }

        int mid=arr.length/2;

        int[] left=sort(Arrays.copyOfRange(arr,0,mid));
        int[] right=sort(Arrays.copyOfRange(arr,mid,arr.length));

        return merge(left, right);
    }

    static int[] merge(int[] first, int[] second) {
      int[] ans=new int[first.length+second.length];
      
      int i=0;
      int j=0;
      int k=0;

      while(i<first.length && j<second.length) {
          if(first[i]<second[j]){
              ans[k]=first[i];
              i++;
          }else{
            ans[k]=second[j];
            j++;
          }
          k++;
      }

      while(i<first.length){
          ans[k]=first[i];
          i++;
          k++;
      }

      while(j<second.length){
        ans[k]=second[j];
        j++;
        k++;
    }

    return ans;
    }
}
