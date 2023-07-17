package Stacks;

import java.util.ArrayList;
import java.util.Stack;

public class stockSpan {
    public static void main(String[] args) {
        int[] arr={100,80,60,70,60,75,85,100};
        int[] arr_2={50,30,45,60,45,70};

        ArrayList<Integer> list = findConsecutiveSmallest(arr_2);
        System.out.println(list);
        ArrayList<Integer> list_1 =findIndexOfNGL(arr);
        System.out.println(list_1);
    }

    private static ArrayList<Integer> findIndexOfNGL(int[] arr) {
        Stack<Integer> stack=new Stack<>();
        ArrayList<Integer> list =new ArrayList<>();
        int idx=0;
        int popped=0;

        for(int i=0; i <arr.length; i++) {
            if (stack.isEmpty()) {
                list.add(-1);
            } else if (!stack.isEmpty() && stack.peek() > arr[i]) {
                list.add(i-1);
            } else if (!stack.isEmpty() && stack.peek() <= arr[i]) {
                while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                    stack.pop();
                    idx++;
                }
                if (stack.isEmpty()) {
                    list.add(-1);
                } else {
                    list.add(i-1-idx);
                }

            }
            stack.push(arr[i]);
        }

        System.out.println(list);
        return modified(list, arr.length);
    }

    private static ArrayList<Integer> modified(ArrayList<Integer> list, int n) {
        ArrayList<Integer> ans =new ArrayList<>();
        for(int i = 0; i < n; i++){
            ans.add(i- list.get(i));
        }

        return ans;
    }

    private static ArrayList<Integer> findConsecutiveSmallest(int[] arr) {
        Stack<Integer> st=new Stack<>();
        ArrayList<Integer> list =new ArrayList<>();
        int count=1;
        int prevCount=count;


        for(int i=0; i < arr.length; i++){
            if(i>0 && arr[i]>arr[i-1]){
                count=prevCount;
            }
            if(st.isEmpty()){
                list.add(1);
            }else if(st.peek()<=arr[i]){
                count++;
                st.pop();
                while(!st.isEmpty() && st.peek()<=arr[i]){
                    count++;
                    st.pop();
                }
                prevCount=count;
                list.add(count);
            }else if(st.peek()>arr[i]){
                list.add(1);
            }
            st.push(arr[i]);
        }

        return list;
    }
}
