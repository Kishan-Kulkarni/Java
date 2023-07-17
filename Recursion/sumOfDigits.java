package Recursion;

public class sumOfDigits {
    public static void main(String[] args) {
        int n=1342;
        int sum=0;
        System.out.println(sumOfDig(n, sum));
        System.out.println(sumOfDig2(n));
    }

    private static int sumOfDig2(int n) {
        //Here the recurence relation itself is used, try using these from now on
        if(n==0){
            return 0;
        }

        return sumOfDig2(n/10)+(n%10);
    }

    private static int sumOfDig(int n, int sum) {
        /*Here the sum is the part of the recursive call because every time a new recursive call happens,
        sum is going to reset to 0 if only included in the bidy of the recursion.Whenever a variable is
        required to update itself every recursive call, include it in the recursive call itself.
        */
        if(n==0){
            return sum;
        }

        sum+=n%10;
        n=n/10;
        return sumOfDig(n, sum);
    }
}
