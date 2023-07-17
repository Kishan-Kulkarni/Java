package Stacks;

import java.util.*;

public class maximumAreaHistogram {
    public static void main(String[] args) {
        int[] arr={6,2,5,4,5,1,6};

        System.out.println(findLS(arr));
        System.out.println(findRS(arr));

        findMaxArea(arr);

        System.out.println(maxArea);
    }

    static int maxArea=0;
    public static void findMaxArea(int[] arr) {

        ArrayList<Integer> right=findRS(arr);
        ArrayList<Integer> left=findLS(arr);
        int currArea=0;

        for(int i=0; i<right.size(); i++){
            if(right.get(i)==0 && left.get(i) == 0){
                currArea=arr[i]*arr.length;
            }else{
                currArea=arr[i]*(right.get(i) + left.get(i)+1);
            }

            if(currArea>maxArea){
                maxArea = currArea;
            }
        }
    }

    public static ArrayList<Integer> findLS(int[] arr) {
        ArrayList<Integer> list=new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int idx=0;

        for(int i=0; i<arr.length; i++){
            if(stack.isEmpty()){
                list.add(-1);
            } else if (!stack.isEmpty() && arr[i]>= stack.peek()) {
                list.add(i-2);
            } else if (!stack.isEmpty() && arr[i]< stack.peek()) {
                while(!stack.isEmpty() && arr[i]< stack.peek()){
                    stack.pop();
                    idx++;
                }

                if(stack.isEmpty()){
                    list.add(-1);
                }else{
                    list.add(i-idx-2);
                }
            }
            stack.push(arr[i]);
        }

        return list;
    }

    public static ArrayList<Integer> findRS(int[] arr) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        int idx=0;

        for(int i=arr.length - 1; i >= 0; i--){
            if(stack.isEmpty()){
                list.add(-1);
            }else if(!stack.isEmpty() && stack.peek()<=arr[i]){
                list.add(i);
            }else if(!stack.isEmpty() && stack.peek() > arr[i]){
                while(!stack.isEmpty() && stack.peek() > arr[i]){
                    stack.pop();
                    idx++;
                }

                if(stack.isEmpty()){
                    list.add(-1);
                }else{
                    list.add(i+idx-1);
                }
            }
            stack.push(arr[i]);
        }

        Collections.reverse(list);

        return list;
    }
}
