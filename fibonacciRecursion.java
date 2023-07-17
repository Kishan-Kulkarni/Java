
public class fibonacciRecursion {
    public static void main(String[] args) {
         int n=50;
         printFibonacci(0,1,n,0);
         printFibonacci(1,1,n,0);
         int answer1= printFibonacci1(n);
        System.out.println(answer1);
    }

     static int printFibonacci1( int n) {
        if(n<=2){
            return n-1;
        }
        return printFibonacci1(n-1)+printFibonacci1(n-2);
    }

     static void printFibonacci(int a, int b, int n, int i) {
        if(n==1){
            System.out.println(0);
            return;
        }

        if(n==2){
            System.out.println(1);
            return;
        }


        if(i==n-2){
          System.out.println(b);
          return;
        }

        printFibonacci(b, b+a, n, i+1);
        
    }
}
