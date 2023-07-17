package LeetCode.Arrays;

public class maxSumArray {
    public static void main(String[] args) {
        System.out.println(kadane(new int[]{-1,-2,-3,-4}));
    }
    public static int kadane(int[] arr){
        int currSum=0;
        int maxSum=Integer.MIN_VALUE;
        for(int i:arr){
            currSum+=i;
            if(currSum>maxSum){
                maxSum=currSum;
            }
            if(currSum<0){
                currSum=0;
            }
        }
        return maxSum;
    }
}
