package Stacks;

import java.util.ArrayList;
import java.util.Stack;

public class stockSpanSolution {
    public static void main(String[] args) {
        int[] arr={100,80,60,70,60,75,85};

        ArrayList<Integer> idx = stackPart(arr);
        ArrayList<Integer> ans = new ArrayList<Integer>();

        for(int i=0; i<idx.size(); i++){
            ans.add(i-idx.get(i));
        }

        System.out.println(ans);
    }

    private static ArrayList<Integer> stackPart(int[] arr) {
        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        int p=0;

        for(int i=0; i< arr.length;i++){
            if(stack.isEmpty()){
                list.add(-1);
            }else if(stack.peek()>arr[i]){
                list.add(i-1);
            }else{
                while(!stack.isEmpty() && stack.peek()<=arr[i]){
                    stack.pop();
                    p++;
                }

                list.add(i-p-1);
            }

            stack.push(arr[i]);
        }

        return list;
    }
}
