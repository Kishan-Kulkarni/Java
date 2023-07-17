package Recursion;

public class checkPalindrome {
    public static void main(String[] args) {
        int n=1010;
        int reverse=revNum(n);
        System.out.println(checkPal(n, reverse));

    }

    private static boolean checkPal(int n, int reverse) {
        return (n==reverse);
    }

    private static int revNum(int n) {
        
        if(n%10==n){
            return n;
        }

        return revNum(n/10)+(n%10 * (int)(Math.pow(10, (int)Math.log10(n))));
    }
}
