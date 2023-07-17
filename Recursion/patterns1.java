package Recursion;

public class patterns1 {
    public static void main(String[] args) {
        int n=4;
        pattern1(n, 0);
        //Another method without using any loops
        triangles(n,0);
    }

    private static void triangles(int r, int c) {

        if(r==0){
            return;
        }

        if(c<r){
            System.out.print("* ");
            triangles(r,c+1);
        }else{
            System.out.println();
            triangles(r-1,0);
        }
    }

    private static void pattern1(int n, int i) {

        if(i==n){
            return;
        }

        // pattern1(n, i+1); This is for the reverse triangle

        for(int j=0; j<n-i; j++){
            System.out.print("* ");
        }
        System.out.println();

        pattern1(n, i+1);
    }
}
