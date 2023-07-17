package Recursion;

public class linearSearch {
    public static void main(String[] args) {
        int[] arr={17,21,39,44,56};
        int target=3;
        System.out.println(search(arr, 0, target));
    }

    private static int search(int[] arr, int i, int target) {
        
        if(i==arr.length){
            return -1;
        }

        if(arr[i]==target){
            return i;
        }

        return search(arr, i+1, target);
        /*If boolean is the return type, return arr[i]==target || search(arr, i+1, target)*/ 
    }
}
