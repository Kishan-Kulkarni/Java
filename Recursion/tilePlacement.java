package Recursion;

public class tilePlacement {
    public static void main(String[] args) {
        int n=4;
        int m=2;
        System.out.println(allTilePlacements(n,m));
    }

    private static int allTilePlacements(int n, int m) {
        if(n==1 || n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }

        return allTilePlacements(n-1, m)+allTilePlacements(n-m, m);

    }
}
