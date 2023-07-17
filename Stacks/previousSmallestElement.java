package Stacks;

import java.util.ArrayList;
import java.util.Stack;

public class previousSmallestElement {
    public static void main(String[] args) {
        int[] arr={1,3,2,3,4};

        ArrayList<Integer> list =findPreviousSmallest(arr);
        System.out.println(list);
    }

    private static ArrayList<Integer> findPreviousSmallest(int[] arr) {
        Stack<Integer> stack = new Stack();
        ArrayList<Integer> list = new ArrayList();

        for(int i=0; i < arr.length; i++){
            if(stack.isEmpty()){
                list.add(-1);
            }else if(stack.peek()<arr[i]){
                list.add(stack.peek());
            }else if(stack.peek() >= arr[i]){
                while(!stack.isEmpty() && stack.peek() >= arr[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    list.add(-1);
                }else{
                    list.add(stack.peek());
                }
            }

            stack.push(arr[i]);
        }

        return list;
    }
}
