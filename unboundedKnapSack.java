import java.util.Arrays;

public class unboundedKnapSack {
    static int[][] t;
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4,5};
        int target=5;
        t=new int[arr.length+1][target+1];
        int[][] dp=new int[arr.length+1][target+1];
        for(int i=0; i<dp.length; i++){
            dp[i][0]=1;
        }
        for(int[] i:t){
            Arrays.fill(i,-1);
        }
        System.out.println(unbounded(arr,target,arr.length));
        for(int[] i:t){
            System.out.println(Arrays.toString(i));
        }
        for(int i=1; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                if(arr[i-1]<=j){
                    dp[i][j]=dp[i][j-arr[i-1]]+dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        System.out.println();
        for(int[] i:dp){
            System.out.println(Arrays.toString(i));
        }
        System.out.println();
        System.out.println(dp[arr.length][target]);
    }

    private static int unbounded(int[] arr, int target, int n) {
        if(n==0){
            if(target==0){
                return 1;
            }

            return 0;
        }

        if(target==0){
            return 1;
        }

        if(t[n][target]!=-1){
            return t[n][target];
        }

        if(arr[n-1]>target){
            return t[n][target]= unbounded(arr, target, n-1);
        }

        return t[n][target]=unbounded(arr, target-arr[n-1], n) + unbounded(arr, target, n-1);
    }
}
