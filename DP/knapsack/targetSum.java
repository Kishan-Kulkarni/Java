package DP.knapsack;

public class targetSum {
    int[][] t=new int[21][2001];
    public  int findTargetSumWays(int[] nums, int target) {
        //    for(int i=0; i<t.length; i++){
        //        for(int j=0; j<t[0].length; j++){
        //            t[i][j]=-1;
        //        }
        //    }
        //     return helper(candidates, target, candidates.length);
        // }

        // public  int helper(int[] candidates, int target, int n) {
        //     if(n==0){
        //         if(target==0){
        //             return t[n][Math.abs(target)]=1;
        //         }
        //         return t[n][Math.abs(target)]=0;
        //     }

        //     if(t[n][Math.abs(target)]!=-1){
        //         return t[n][Math.abs(target)];
        //     }

        //     return t[n][Math.abs(target)]=helper(candidates, target-candidates[n-1],n-1) + helper(candidates, target+candidates[n-1], n-1);

        int sum = 0;
        for(int x : nums)
            sum += x;
        if(((sum - target) % 2 == 1) || (target > sum))
            return 0;

        int n = nums.length;
        int s2 = (sum - target)/2;
        int[][] t = new int[n + 1][s2 + 1];
        t[0][0] = 1;

        for(int i = 1; i < n + 1; i++) {
            for(int j = 0; j < s2 + 1; j++) {
                if(nums[i - 1] <= j)
                    t[i][j] = t[i-1][j] + t[i - 1][j - nums[i - 1]];
                else
                    t[i][j] = t[i - 1][j];
            }
        }
        return t[n][s2];
    }
}
