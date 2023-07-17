package LeetCode.Arrays;

import java.util.HashSet;

public class longestContinuous {
    static int[] min=new int[]{Integer.MAX_VALUE};
    public static int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        HashSet<Integer> set=new HashSet<>();
        for(int i:nums){
            set.add(i);
            if(i<min[0]){
                min[0]=i;
            }
        }
        int ans=0;
        while(!set.isEmpty()){
            if(set.contains(min[0])){
                ans=Math.max(ans, check(set, min));
            }else{
                min[0]++;
            }
        }
        return ans;
    }
    public static int check(HashSet<Integer> set, int[] s){
        int ans=0;
        while(set.contains(s[0])){
            set.remove(s[0]);
            ans++;
            s[0]++;
        }
        int next=Integer.MAX_VALUE;
        for(int i: set){
            if(i<next){
                next=i;
            }
        }
        s[0]=next;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100,4,200,1,3,2}));
    }
}
