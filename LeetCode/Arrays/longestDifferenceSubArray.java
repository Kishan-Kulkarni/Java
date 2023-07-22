package LeetCode.Arrays;

import java.util.ArrayList;

public class longestDifferenceSubArray {
    public static int longestArray(int [] nums, int limit){
        int i=0, j=0;
        int max=Integer.MIN_VALUE;
        ArrayList<Integer> high=new ArrayList<Integer>();
        ArrayList<Integer> low=new ArrayList<Integer>();
        while(j<nums.length && i<=j){
            if(high.size()==0 || high.get(0)<=nums[j]){
                high.add(0, nums[j]);
            }
            if(low.size()==0 || low.get(0)>=nums[j]){
                low.add(0, nums[j]);
            }
            if(Math.abs(high.get(0)-low.get(0))<=limit){
                if(max<j-i+1){
                    max=j-i+1;
                }
            }else{
                if(high.size()!=0 && nums[i]==high.get(0)){
                    high.remove(0);
                }
                if(low.size()!=0 && nums[i]==low.get(0)){
                    low.remove(0);
                }
                i++;
                j--;
            }
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestArray(new int[]{4,2,2,2,4,4,2,2}, 0));
    }
}
