package LeetCode.Arrays;

import java.util.Arrays;

public class cyclicSort {
    public static void main(String[] args) {
        int[] nums={1,1,2};
        for(int i=0; i<nums.length; i++){
            if(nums[nums[i]-1]!=nums[i]){
                int t=nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];
                nums[i]=t;
                i--;
            }
        }

        System.out.println(Arrays.toString(nums));
    }
}
