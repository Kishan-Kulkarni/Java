package LeetCode.Arrays;

public class getSquares {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int left=0;
        int right=nums.length-1;
        int curr= nums.length-1;
        while(curr>=0){
            if(nums[left]*nums[left]>nums[right]*nums[right]){
                ans[curr]=nums[left]*nums[left];
                left++;
            }else{
                ans[curr] = nums[right]*nums[right];
                right--;
            }
            curr--;
        }

        return ans;    }
}
