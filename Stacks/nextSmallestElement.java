package Stacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class nextSmallestElement {
    public static void main(String[] args) {

        int[] arr={4,3,2,3,1};

        ArrayList<Integer> list=findNextSmallest(arr);
        Collections.reverse(list);
        System.out.println(list);
    }

    private static ArrayList<Integer> findNextSmallest(int[] arr) {

        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Integer> list=new ArrayList<>();

        for(int i=arr.length - 1; i >= 0; i--){
            if(stack.isEmpty()){
                list.add(-1);
            }else if(stack.peek()<arr[i]){
                list.add(stack.peek());
            }else if(stack.peek()>=arr[i]){
                while(!stack.isEmpty() && stack.peek()>=arr[i]){
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
