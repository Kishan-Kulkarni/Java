package Recursion;

public class numberOfSteps {
    public static void main(String[] args) {
        int n=21;
        System.out.println(stepCounter(n));
    }

    static int counter=0;

    private static int stepCounter(int n) {
        if(n==0){
            return counter;
        }

        if(n%2==0){
            counter++;
            return stepCounter(n/2);
        }

        counter++;
        return stepCounter(n-1);
    }
}
