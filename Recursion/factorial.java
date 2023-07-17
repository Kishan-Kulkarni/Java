package Recursion;

public class factorial {
    public static void main(String[] args) {
        int n=19;
        System.out.println(fac(n));
    }

    private static int fac(int n) {

        if(n==1 || n==0){
            return 1;
        }

        return n*fac(n-1);
    }
}
