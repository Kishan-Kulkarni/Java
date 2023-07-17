package Recursion;

public class checkArraySorting {
    public static void main(String[] args) {
        int[] arr= {1,2,3,40,500};
        System.out.println(sortedArray(arr, 0));
    }

    private static boolean sortedArray(int[] arr, int i) {
        if(i==arr.length-1){
            return true;
        }

        if(arr[i]>arr[i+1]){
            return false;
        }

        return sortedArray(arr, i+1);
    }
}
