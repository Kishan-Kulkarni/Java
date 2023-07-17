package Recursion;

public class numberOfZeroes {
    public static void main(String[] args) {
        int n=103040;
        noOfZeroes(n);
    }

    static int counter=0;
    private static void noOfZeroes(int n) {
        
        if(n%10==n){
            System.out.println(counter);
            return;
        }

        if(n%10==0){
            counter++;
        }

        noOfZeroes(n/10);

    }
}
