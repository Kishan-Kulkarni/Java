package Stacks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

public class nextLargestElement {
    public static void main(String[] args) {
        int[] arr= new int[]{1, 3, 0, 0, 1, 2, 4, 12, 4, -2, 0, 1, 4, 5, 2, 6, 11, 7, 1, 6};
        boolean found = false;

        float timeBefore=System.currentTimeMillis();

        for(int i=0; i<arr.length-1; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i]<arr[j]){
                    System.out.print(arr[j] + " ");
                    found=true;
                    break;
                }
            }
            if(!found){
                System.out.print(-1 + " ");
            }
            found=false;
        }

        System.out.println(-1);

        float timeAfter=System.currentTimeMillis();

        System.out.println(timeAfter-timeBefore);

        float funcTimeB = System.currentTimeMillis();
        ArrayList<Integer> list=findNextLargest(arr);
        Collections.reverse(list);
        float funcTimeA = System.currentTimeMillis();
        System.out.println(funcTimeA-funcTimeB);
        System.out.println(list);
    }

    private static ArrayList<Integer> findNextLargest(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list =new ArrayList<>();

        for(int i=arr.length - 1; i >= 0; i--){
            if(stack.isEmpty()){
                list.add(-1);
            }else if(!stack.isEmpty() && stack.peek()>arr[i]){
                list.add(stack.peek());
            }else if(!stack.isEmpty() && stack.peek() <= arr[i]){
                while(!stack.isEmpty() && stack.peek() <= arr[i]){
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
