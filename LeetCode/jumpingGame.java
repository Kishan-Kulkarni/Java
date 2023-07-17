package LeetCode;

import java.util.HashMap;

public class jumpingGame {
    static HashMap<Integer, Integer> map=new HashMap<>();
    public static int jump(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        return helper(nums, 0);
    }
    public static int helper(int[] nums, int n){
        if(n== nums.length-1){
            return 0;
        }

        if(map.containsKey(n)){
            return map.get(n);
        }

        if(n+nums[n]>=nums.length-1){
            return 1;
        }

        if(nums[n]==0){
            return Integer.MAX_VALUE/2;
        }

        int min=Integer.MAX_VALUE;
        for(int i=1; i<=nums[n]; i++){
            int steps=helper(nums, n+i)+1;
            min=Math.min(min,steps);
        }
        map.put(n,min);
        return min;
    }

    //class Solution {
    //  public int jump(int[] nums) {
    //    int ans = 0;
    //    int end = 0;
    //    int farthest = 0;
    //
    //    // Implicit BFS
    //    for (int i = 0; i < nums.length - 1; ++i) {
    //      farthest = Math.max(farthest, i + nums[i]);
    //      if (farthest >= nums.length - 1) {
    //        ++ans;
    //        break;
    //      }
    //      if (i == end) {   // Visited all the items on the current level
    //        ++ans;          // Increment the level
    //        end = farthest; // Make the queue size for the next level
    //      }
    //    }
    //
    //    return ans;
    //  }
    //}

    public static void main(String[] args) {
        System.out.println(jump(new int[]{1,2}));
    }
}
