package Stacks;

import Stacks.reverseStackLab;

import java.util.Scanner;
import java.util.Stack;

public class TowerOfHanoiStack {
    static Stack<Integer>[] towers=new Stack[4];

    public static void hanoi(int n){

        for(int i=n; i>0; i--){
            towers[1].push(i);
        }

        rearrange(n, 1,2,3);
    }
    public static void rearrange(int n, int a, int b, int c) {
        if(n>0){
            rearrange(n-1, a, c, b);
            int i=towers[a].pop();
            towers[c].push(i);
            rearrange(n-1, b, a, c);
        }
    }
    public static void main(String[] args) {
        for(int i=1; i<4; i++){
            towers[i]=new Stack<>();
        }
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        hanoi(n);
        for(int i=1; i<4; i++){
            reverseStackLab.reverseStack(towers[i]);
            System.out.println(towers[i]);
        }
        sc.close();
    }
}





