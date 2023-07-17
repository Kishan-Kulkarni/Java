package Recursion;

public class checkArray {
    public static void main(String[] args) {
        int[] arr={1,2,3,40,5};
        System.out.println(sortedCheck(arr,0));
    }

    private static boolean sortedCheck(int[] arr, int i) {
        
        if(i==arr.length-1){
            return true;
        }

        if(arr[i]>arr[i+1]){
            return false;
        }


        return sortedCheck(arr, i+1);
        /*return arr[i]<arr[i+1]&&sortedCheck(arr, i+1); is a more clean looking return and the additional if
        condition will not be needed
        */
    }
}
