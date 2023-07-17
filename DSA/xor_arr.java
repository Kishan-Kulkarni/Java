package DSA;
import java.util.*;
public class xor_arr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the number of element in array:");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Please eter the array in which all but 1 element repeats");
        for(int i=0; i<arr.length; i++){
            arr[i]=sc.nextInt();
        }
        int result =0;

        for(int i=0; i<arr.length; i++){
            result = result^arr[i];
        }
        System.out.println("The unique element is " +result);
        sc.close();
    }
}
