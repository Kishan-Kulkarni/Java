package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class combinationSum2 {
    static List<List<Integer>> ans=new ArrayList<>();
    static HashSet<List<Integer>> set=new HashSet<>();
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, target, 0, new ArrayList<>());
        return ans;
    }
    public static void helper(int[] nums, int target, int i, List<Integer> list){
        if(target==0){
            if(!set.contains(list)){
                ans.add(new ArrayList<>(list));
                set.add(new ArrayList<>(list));
            }
            return;
        }
        if(i>=nums.length){
            return;
        }
        if(nums[i]<=target){
            helper(nums, target, i+1, new ArrayList<>(list));
            list.add(nums[i]);
            helper(nums,  target-nums[i],i+1, new ArrayList<>(list));
            list.remove(list.size()-1);
        }
        return;
    }

    public static void main(String[] args) {
        List<List<Integer>> ans=combinationSum2(new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, 30);
        for(List<Integer> list : ans){
            System.out.println(list);
        }
    }
}
