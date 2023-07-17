package Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class subSetIterative {
    public static void main(String[] args) {

        int[] arr={1,2,2};
        ArrayList<ArrayList<Integer>> list= subSet(arr);
        for(ArrayList<Integer> random:list){
            System.out.println(random);
        }

        ArrayList<ArrayList<Integer>> list1= subSetDuplicte(arr);
        for(ArrayList<Integer> random:list1){
            System.out.println(random);
        }
    }

    static ArrayList<ArrayList<Integer>> subSet(int[] arr){
        ArrayList<ArrayList<Integer>> external= new ArrayList<ArrayList<Integer>>();
        external.add(new ArrayList<Integer>());

        for(int num: arr){
            int n=external.size();
            for(int i=0; i<n; i++){
                ArrayList<Integer> internal =new ArrayList<>(external.get(i));
                internal.add(num);
                external.add(internal);
            }
        }

        return external;
    }

    static ArrayList<ArrayList<Integer>> subSetDuplicte(int[] arr){
        Arrays.sort(arr);

        ArrayList<ArrayList<Integer>> external= new ArrayList<ArrayList<Integer>>();
        external.add(new ArrayList<Integer>());
        
        int start=0;
        int end =0;

        for(int i=0; i<arr.length; i++){
            start=0;

            if(i>0 && arr[i]==arr[i-1]){
                start=end+1;
            }
            end=external.size()-1;

            int n=external.size();
            for(int j=start; j<n; j++){
                ArrayList<Integer> internal =new ArrayList<>(external.get(j));
                internal.add(arr[i]);
                external.add(internal);
            }
        }

        return external;
    }
}
