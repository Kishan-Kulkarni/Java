package LeetCode.Arrays;


import java.util.Arrays;

public class findMaxAndMin {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findMaxMin(new int[] {1,2,3,4,-10,20})));
    }
    public static int[] findMaxMin(int[] arr){
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        for(int i:arr){
            if(i>max){
                max=i;
            }
            if(i<min){
                min=i;
            }
        }
        return new int[]{min,max};
    }
}
