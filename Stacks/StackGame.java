package Stacks;

public class StackGame {
    public static void main(String[] args) {
        int[] a={1,2,3,4,5};
        int[] b = {6,7,8,9};

        System.out.println(twoStackGame(a,b,0,0,10));
    }

    public static int twoStackGame(int[] a, int[] b, int i, int j, int maxSum){

        if(i==a.length){
            return 0;
        }

        if(j== b.length){
            return 0;
        }

        if(a[i]>maxSum){
            return 1;
        }

        if(b[j]>maxSum){
            return 1;
        }

        return Math.max(twoStackGame(a,b,i+1,j,maxSum-a[i])+1, twoStackGame(a,b,i,j+1,maxSum - b[j]));
    }
}
