package Recursion;

import java.util.ArrayList;

public class VImpallOccurences {
    public static void main(String[] args) {
        int [] arr={1,2,3,4,4,8};
        // ArrayList<Integer> list= new ArrayList<>();
        // list=findAllOccurence(arr, 4,0);
        // System.out.println(list);
        System.out.println(findAllOccurence(arr, 4,0));
    }

    public static ArrayList<Integer> findAllOccurence(int[] arr, int target, int i) {
        ArrayList<Integer> list= new ArrayList<>();

        if(i==arr.length){
            /*Happens at the final call returns to the answerFromBelow line (1st return to line 30) */
            return list;
        }

        //Adds the item for that function call in the stack
        if(arr[i]==target){
            list.add(i);
        }

        /*While the fuction are being cleared from the stack this is executed which takes in the values
         added by the above if statement
         */
        ArrayList<Integer> answerFromBelowCalls= findAllOccurence(arr, target, i+1);/*This is where the fuction comes out of once it is 
                                                                                    cleared from the stack. After the stack starts emptying
                                                                                    , it will loop in these last 3 lines as it exits the function
                                                                                    calls from here sro the return stement in the last line*/
        list.addAll(answerFromBelowCalls);

        return list;//Returns the list of that function call to line 30

    }
}
