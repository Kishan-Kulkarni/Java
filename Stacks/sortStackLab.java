package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class sortStackLab {
   public static void main(String[] args) {
    Stack<Integer> st=new Stack<>();

    
    Scanner sc=new Scanner(System.in);

    int n=sc.nextInt();

    for (int i = 0; i < n; i++) {
        st.push(sc.nextInt());
    }

       System.out.println(st);
    Stack<Integer> rev;
    rev=sortstack(st);

       System.out.println(rev);

    sc.close();
   }

   public static Stack<Integer> sortstack(Stack<Integer> input)
    {
        Stack<Integer> tmpStack = new Stack<Integer>();
        while(!input.isEmpty())
        {

            int tmp = input.pop();

            while(!tmpStack.isEmpty() && tmpStack.peek() > tmp)
            {
            input.push(tmpStack.pop());
            }
             

            tmpStack.push(tmp);
        }
        return tmpStack;
    }
}

