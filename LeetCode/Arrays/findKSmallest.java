package LeetCode.Arrays;

public class findKSmallest {
    public static void main(String[] args) {
        System.out.println(kthSmallest(new int[] {7,10,4,20,15}, 4));
    }
    public static int kthSmallest(int[] arr, int k){
        int min=Integer.MAX_VALUE;
        int minIdx=0;
        for(int j=0; j<k; j++){
            min=Integer.MAX_VALUE;
            for(int i = 0; i < arr.length; i++){
                if(arr[i]<=min){
                    min=arr[i];
                    minIdx=i;
                }
            }
            arr[minIdx]=Integer.MAX_VALUE;
        }
        return min;
    }
}
