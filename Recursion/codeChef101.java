package Recursion;

import java.util.Scanner;

public class codeChef101 {
    public static void main(String[] args) {
        int T;
        Scanner sc=new Scanner(System.in);
        T=sc.nextInt();

        while(T>0){
            int B=sc.nextInt();
            System.out.println(printAnswer(B,0));
            T--;
        }

        sc.close();
    }

    static int i=0;

    private static int printAnswer(int B, int sum) {
       if(B<=3){
        return sum;
       }

       if(B%2==0){
        i++;
        return printAnswer(B-2, sum+i);
       }else{
        return printAnswer(B-1, sum);
       }
    }

    
}
