package Recursion;

public class reversingNumber {
    public static void main(String[] args) {
        int n=12345;
        System.out.println(revNum(n));
    }

    private static int revNum(int n) {
        
        if(n%10==n){
            return n;
        }

        return revNum(n/10)+(n%10 * (int)(Math.pow(10, (int)Math.log10(n))));
    }
}
