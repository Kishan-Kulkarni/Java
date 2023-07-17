package LeetCode.Arrays;

public class moveZero {
    public static void moveZeroes(int[] nums) {
        if(nums.length<=1){
            return ;
        }
        double temp1=Double.MIN_VALUE;
        System.out.println(temp1);
        int curr=0, swap=1;
        while(curr<nums.length && swap< nums.length){
            if(nums[curr]==0){
                int temp=nums[curr];
                nums[curr]=nums[swap];
                nums[swap]=temp;
                swap++;
                if(nums[curr] !=0){
                    curr++;
                }
            }else{
                curr++;
                swap++;
            }
        }
    }

    public static void main(String[] args) {
        moveZeroes(new int[]{0,1,0,3,12});
    }
}
