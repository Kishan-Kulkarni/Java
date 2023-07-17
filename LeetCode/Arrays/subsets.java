package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class subsets {
    static HashSet<List<Integer>> set=new HashSet<>();
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        return helper(nums, 0, new ArrayList<>());
    }
    public static List<List<Integer>> helper(int[] nums, int i, List<Integer> list){
        if(i==nums.length){
            List<List<Integer>> ans=new ArrayList<>();
            List<Integer> curr=new ArrayList<>(list);
            Collections.sort(list);
            if(!set.contains(list)){
                set.add(list);
                ans.add(list);
            }
            return ans;
        }
        List<List<Integer>> ans = new ArrayList<>(helper(nums, i + 1, new ArrayList<>(list)));
        list.add(nums[i]);
        ans.addAll(helper(nums, i+1, new ArrayList<>(list)));
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> ans=subsetsWithDup(new int[]{4,4,4,4,1,4});
        for(List<Integer> list : ans){
            System.out.println(list);
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(1);
        list.remove(2);
        System.out.println(list);
    }
}
