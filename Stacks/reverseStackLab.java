package Stacks;

import java.util.Scanner;
import java.util.Stack;



public class reverseStackLab {
    public static void main(String[] args) {
        Stack<Integer> st=new Stack<>();

        int temp;

        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        for (int i = 0; i < n; i++) {
            temp=sc.nextInt();
            st.push(temp);
        }

        
        System.out.println(st);
        reverseStack(st);
        System.out.println();
        System.out.println(st);
        sc.close();
    }

    public static void insertAtBottom(Stack<Integer> s, int item)
    {
        if (s.empty())
        {
            s.push(item);
            return;
        }
 
        int top = s.pop();
        insertAtBottom(s, item);
 

        s.push(top);
    }
 
    public static void reverseStack(Stack<Integer> s)
    {
        if (s.empty()) {
            return;
        }
 
        int item = s.pop();
        reverseStack(s);
 
        insertAtBottom(s, item);
    }
}
