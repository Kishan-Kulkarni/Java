package DP.unbounded;


public class UnboundedKnappSack {
    static int[][] t=new int[100][100];
    public static void main(String[] args) {
        int[] w={1,3,4,5,3,12,15,1,10};
        int[] v={10,4,5,7,10,17,6,13,5};
        int W=50;

        for(int i=1; i<t.length; i++){
            for(int j=1; j < t[i].length; j++){
                t[i][j]=-1;
            }
        }

        int[][] memo= new int[100][100];

//        for(int i=1; i<t.length; i++){
//            for(int j=1; j < t[i].length; j++){
//                memo[i][j]=-1;
//            }
//        }

        for(int i=1; i<=w.length; i++){
            for(int j=0; j<=W; j++){
                if(w[i-1]<=j){
                    memo[i][j]=Math.max(memo[i][j-w[i-1]]+v[i-1], memo[i-1][j]);
                }else{
                    memo[i][j]=memo[i-1][j];
                }
            }
        }

        System.out.println(unboundedSack(w,v,W, w.length));
        System.out.println(memo[w.length][W]);
    }

    private static int unboundedSack(int[] w, int[] v, int W, int n) {

        if(W<=0){
            return 0;
        }

        if(n==0){
            return 0;
        }

        if(w[n-1]>W){
            t[n][W]= unboundedSack(w,v,W,n-1);
        }

        if(t[n][W]==-1){
            return t[n][W]=Math.max(unboundedSack(w,v, W-w[n-1], n)+v[n-1], unboundedSack(w,v,W,n-1));
        }else{
            return t[n][W];
        }
    }
}
