package DSA;

import java.util.Arrays;

public class radixSortLab {
    public static void main(String[] args) {
        int[] arr = {12,567,842,77,2};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int maxArr(int[] arr){
        int max=Integer.MIN_VALUE;

        for (int j : arr)
            if (max < j) {
                max = j;
            }

        return max;
    }

    public static void sort(int[] arr, int p){
        int[] result=new int[arr.length+1];
        int[] count= new int[10];

        for (int j : arr) {
            count[(j / p) % 10]++;
        }

        for(int i=1; i<10;i++){
            count[i]+=count[i-1];
        }

        for(int i=arr.length - 1; i >= 0; i--){
            result[count[(arr[i]/p)%10]-1]=arr[i];
            count[(arr[i] / p) % 10]--;
        }

        for(int i=0; i<arr.length; i++){
            arr[i]=result[i];
        }
    }

    public static void radixSort(int[] arr){
        int max =maxArr(arr);

        for(int p=1; max/p>0; p*=10){
            sort(arr,p);
        }
    }


}
