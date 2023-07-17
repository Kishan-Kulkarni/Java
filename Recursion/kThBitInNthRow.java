package Recursion;

public class kThBitInNthRow {
    public static void main(String[] args) {
        int n=1;
        int k=2;
        System.out.println(getString("0", n, "",n ));
        System.out.println(kThBit(n-1, k-1));
    }

    private static int kThBit(int n, int k) {
        if(n==0){
            return 0;
        }

        String ans=getString("0", n, "", n+1);
        return Integer.valueOf(ans.charAt(k-1))-48;
    }


    private static String getString(String s, int n, String p, int x) {
        if(n==0){
            return p;
        }

        if(s.isEmpty()){
            return getString(p, n-1, p.substring(x-n), x);
        }

        if(s.charAt(0)=='0'){
            return getString(s.substring(1), n, p+"01", x);
        }else{
            return getString(s.substring(1), n, p+"10", x);          
        }
    
    }
}
