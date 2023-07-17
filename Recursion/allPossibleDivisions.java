package Recursion;

public class allPossibleDivisions {
    public static void main(String[] args) {
        int n=6;
        int m=4;
        System.out.println(printNumberOfDivisions(n,m ,m, n-m));
    }

    private static int printNumberOfDivisions(int n, int m, int a, int b) {
        if(a<=m ){
            return 1;
        }

        if(a>m){
            return 0;
        }

        int count =0;
        
        for(int i=1; i<n; i++){
            count +=printNumberOfDivisions(n, m, 0, 0);
        }

        return count;
    }
}
