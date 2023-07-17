package DP.misc;

import java.util.HashMap;
import java.util.Map;

public class gridTraveller {
    private Map<String , Long> memo= new HashMap<>();
    private long cache[][]= new long[1000][1000];

    public gridTraveller(long[][] cache) {
        this.cache = cache;
    }

    public gridTraveller(){

    }

    public long noOfStepsDP(int n, int m){
        if(n==0 || m==0){
            return 0;
         }
 
         if(n==1 && m==1){
             return 1;
         }

         String key = m + "|" + n;
         
         if(this.memo.containsKey(key)){
            return this.memo.get(key);
         }

         long result =  noOfStepsDP(n-1, m) + noOfStepsDP(n, m-1);
         this.memo.put(key, result);

         return result;
    }

    public long noOfStepsDP1(int n, int m){
        if(cache[n][m]==0){
            if(n==0 || m==0){
                return 0;
             }
     
             if(n==1 && m==1){
                 return 1;
             }

             long result= noOfStepsDP1(n-1, m) + noOfStepsDP1(n, m-1);
             cache[n][m]=result;
        }

        return cache[n][m];
    }
    public static void main(String[] args) {
        int n=18, m=18;
        long preTime1 = System.currentTimeMillis();
        System.out.println(new gridTraveller().noOfStepsDP(n, m));
        long postTime1= System.currentTimeMillis();
        System.out.println(postTime1-preTime1);
        long preTime2= System.currentTimeMillis();
        System.out.println(noOfSteps(n, m));
        long postTime2 =System.currentTimeMillis();
        System.out.println(postTime2-preTime2);
        long preTime3= System.currentTimeMillis();
        System.out.println(new gridTraveller().noOfStepsDP1(n, m));
        long postTime3 =System.currentTimeMillis();
        System.out.println(postTime3-preTime3);
    }


    private static long noOfSteps(int n, int m) {
        if(n==0 || m==0){
           return 0;
        }

        if(n==1 && m==1){
            return 1;
        }
        
       return noOfSteps(n-1, m) + noOfSteps(n, m-1);
    }
}
