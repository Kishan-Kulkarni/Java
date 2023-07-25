package LeetCode.Arrays;

import java.util.Arrays;

public class aggresiveCows {
    public static int aggressiveCows(int []stalls, int k) {
        Arrays.sort(stalls);
        int s=1;
        int e=getMax(stalls);
        int res=-1;
        while(s<=e){
            int m=(e-s)/2 + s;
            int cows=getStalls(stalls, m);
            if(cows<k){
                e=m-1;
            }else{
                res=m;
                s=m+1;
            }
        }
        return res;
    }
    public static int getMax(int[] arr){
        int max=-1;
        for(int i:arr){
            if(i>max){
                max=i;
            }
        }
        return max;
    }

    public static int getStalls(int[] stalls, int dist){
        int n = stalls.length; //size of array
        int cntCows = 1; //no. of cows placed
        int last = stalls[0]; //position of last placed cow.
        for (int i = 1; i < n; i++) {
            if (stalls[i] - last >= dist) {
                cntCows++; //place next cow.
                last = stalls[i]; //update the last location.
            }
        }
        return cntCows;
    }
}
