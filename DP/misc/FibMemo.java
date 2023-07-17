package DP.misc;

public class FibMemo {
     long cache[];
    
    FibMemo(long[] cache){
        this.cache=cache;
    }

    public  long newFib(int n){
        if(cache[n]==0){
            if(n<2){
                return 1;
            }else{
                cache[n]=newFib(n-1)+newFib(n-2);
            }
        }

        return cache[n];
    }

    public static void main(String[] args) {
        int n=100;
        int preTime=(int)System.currentTimeMillis();
        System.out.println(new FibMemo(new long[n+1]).newFib(n));
        int postTime=(int)System.currentTimeMillis();
        int totalTime=postTime-preTime;
        System.out.println(totalTime);
    }
}
