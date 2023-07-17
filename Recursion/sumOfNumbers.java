package Recursion;


public class sumOfNumbers {
    public static void main(String[] args) {
        System.out.println(printSum(10)); 
    }

    private static int printSum(int n) {
        if(n==0){
            return 0;
        }

        return printSum(n-1)+n;
    }
}
