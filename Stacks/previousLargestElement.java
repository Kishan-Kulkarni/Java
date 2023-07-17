package Stacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class previousLargestElement {
    public static void main(String[] args) {
        int[] arr={4,2,3,1};

        ArrayList<Integer> list =findPreviousLarger(arr);
        //Collections.reverse(list);
        System.out.println(list);
    }

    private static ArrayList<Integer> findPreviousLarger(int[] arr) {
        Stack<Integer> stack=new Stack<>();
        ArrayList<Integer> list =new ArrayList<>();

        for (int j : arr) {
            if (stack.isEmpty()) {
                list.add(-1);
            } else if (!stack.isEmpty() && stack.peek() > j) {
                list.add(stack.peek());
            } else if (!stack.isEmpty() && stack.peek() <= j) {
                while (!stack.isEmpty() && stack.peek() <= j) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    list.add(-1);
                } else {
                    list.add(stack.peek());
                }
            }
            stack.push(j);
        }

        return list;
    }
}
