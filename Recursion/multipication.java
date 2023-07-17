package Recursion;

public class multipication {
    public static void main(String[] args) {
        printProduct(5000,1000,0);
        System.out.println(printProduct1(5,10));
    }

    static int printProduct1(int i, int j) {
        if(j==0){
            return 0;
        }

        return printProduct1(i, j-1)+i;
    }

    static void printProduct(int i, int j,int product) {
        if(j==0){
            System.out.println(product);
            return;
        }     
        printProduct(i, j-1, product+i);
    }
}
