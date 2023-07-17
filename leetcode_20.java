import java.util.Arrays;

public class leetcode_20 {
    public static void main(String[] args) {
        int[][] mat={{0 ,0 ,0}, {0,1,0}, {1,1,1}};
        int[][] check = new int[mat.length][mat.length];
        int k=0;
        while(k<4){
            for(int i=0; i<mat.length; i++){
                for(int j=0; j<mat.length; j++){
                    check[i][j]=mat[j][i];
                }
            }
            for(int i=0; i<mat.length; i++){
                int temp =check[i][0];
                check[i][0]=check[i][mat.length-1];
                check[i][mat.length-1]=temp;
            }
            for(int i=0; i<mat.length; i++){
                System.out.println(Arrays.toString(check[i]));
            }
            System.out.println();
            System.out.println();
            k++;
            for(int i=0; i<mat.length; i++){
                for(int j=0; j<mat.length; j++){
                    mat[i][j]=check[i][j];
                }
            }
        }
    }
}
