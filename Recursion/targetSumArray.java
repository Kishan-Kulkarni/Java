package Recursion;

public class targetSumArray {
    public static void main(String[] args) {
        int arr[]={1,1,1,1,1};
        int target=3;
        System.out.println(findTargetSumWays(arr, target));
    }

    private static int findTargetSumWays(int[] arr, int target) {

        return helper(arr, target, 0, "");
    }

    private static int helper(int[] arr, int target, int i, String op) {
        int count=0;

        if(target==0){
            if(i==arr.length){
                count++;
                System.out.println(op);
                return count;
            }else{
                return count+ helper(arr, target+arr[i], i+1, op+"-" )+ helper(arr, target-arr[i], i+1, op+"+");
            }
        }

        if(i==arr.length){
            return 0;
        }

        
        return count + helper(arr, target-arr[i], i+1, op+"+") + helper(arr, target+arr[i], i+1, op+"-");
    }
}
