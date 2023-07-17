package Recursion;

import java.util.Scanner;

public class specialFiboNumbers {
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int T=sc.nextInt();
       
       while(T>0){
        int a=sc.nextInt();
        int b=sc.nextInt();
        int n=sc.nextInt();
        
        printSpecialFibo(a, b, n,  1);
        T--;
       }

       sc.close();
    }

    private static void printSpecialFibo(int a, int b, int n, int i) {
        if(i==n){
            System.out.println(b);
            return;
        }

        printSpecialFibo(b, b^a, n, i+1);
    }
}
