package DP.misc;

import java.util.HashMap;
import java.util.Map;

public class FibMemoHasMaps {
    private Map<Integer, Long> memo= new HashMap<>();

    public long fibMemo(int n){
        if(n<2){
            return n;
        }

        if(this.memo.containsKey(n)){
            return this.memo.get(n);
        }

        long result =fibMemo(n-1) + fibMemo(n-2);
        this.memo.put(n, result);

        return result;
    }
    public static void main(String[] args) {
        System.out.println(new FibMemoHasMaps().fibMemo(100));
    }
}
