package DP.knapsack;

public class Knapsack {

    static int t[][] =new int[100][100];
    
    public static void main(String[] args) {
        maxprofit(new int[]{1,3,4,5,3,12,15,6,10}, new int[]{10,4,5,7,10,17,6,13,5}, 50);
        
        System.out.println(max_int);
    }

    static int max_int =0;
    public static int maxprofit(int[] w, int[] v, int W){
        return helper(w,v,W,0,0, 0);
    }

    public static int helper(int[] w, int[] v, int W, int curr_profit,int curr_weigth, int i) {
        if(i==w.length){
            return max_int;
        }

        if(curr_weigth>W){
            return 0;
        }
        
        if(curr_profit>max_int){
            max_int=curr_profit;
        }


        if(t[i][curr_weigth]==0){        
            return t[i][curr_weigth]=Math.max(helper(w, v, W, curr_profit+v[i], curr_weigth+w[i], i+1), helper(w, v, W, curr_profit, curr_weigth, i+1));
        }else{
            return t[i][curr_weigth];
        }

    }

    public static class knapSack {

        static int t[][] =new int[100][100];

        public static void main(String[] args) {
            maxprofit(new int[]{1,3,4,5,3,12,15,6,10}, new int[]{10,4,5,7,10,17,6,13,5}, 50);

            System.out.println(max_int);
        }

        static int max_int =0;
        public static int maxprofit(int[] w, int[] v, int W){
            return helper(w,v,W,0,0, 0);
        }

        public static int helper(int[] w, int[] v, int W, int curr_profit,int curr_weigth, int i) {
            if(i==w.length){
                return max_int;
            }

            if(curr_weigth>W){
                return 10;
            }

            if(curr_profit>max_int){
                max_int=curr_profit;
            }


            if(t[i][curr_weigth]==0){
                return t[i][curr_weigth]=Math.max(helper(w, v, W, curr_profit+v[i], curr_weigth+w[i], i+1), helper(w, v, W, curr_profit, curr_weigth, i+1));
            }else{
                return t[i][curr_weigth];
            }

        }
    }
}
