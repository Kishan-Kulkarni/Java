package LeetCode.Arrays;

import java.util.Arrays;
import java.util.OptionalInt;

public class kokoBananas {
    public static int minEatingSpeed(int[] piles, int h) {
        int s=1;
        int e=findMax(piles);
        int res=-1;
        while(s<=e){
            int m=(e-s)/2 + s;
            if(check(piles, m)>h){
                s=m+1;
            }else if(check(piles, m)<=h){
                res=m;
                e=m-1;
            }
        }
        return res;
    }
    public static int findMax(int[] piles){
        int max=0;
        for(int i:piles){
            if(i>max){
                max=i;
            }
        }
        return max;
    }
    public static long check(int[] piles, int rate){
        long hours=0;
        for(int i:piles){
            hours+=(i/rate);
            if(i%rate!=0){
                hours++;
            }
        }
        return hours;
    }

    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{805306368,805306368,805306368}, 1000000000));
        int[] arr={1,23,4,5};
    }
}
