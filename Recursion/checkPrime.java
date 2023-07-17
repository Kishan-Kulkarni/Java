package Recursion;

public class checkPrime {
    public static void main(String[] args) {
        prime(1,2);
    }

    private static void prime(int n, int i) {
        if(n<=2){
            System.out.println(n==2?true:false);
            return;
        }

        if(i*i==n){
            System.out.println(true);
            return;
        }

        if(n%i==0){
            System.out.println(false);
            return;
        }

        prime(n, i+1);
    }
}
