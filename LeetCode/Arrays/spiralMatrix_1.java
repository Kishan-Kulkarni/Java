package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.List;

public class spiralMatrix_1 {
    public static void main(String[] args) {

    }

    public static int[][] spiral(int n){
        int[][] matrix =new int[n][n];

        boolean rl=false, rr=true, cd=false , cu=false;
        int ruo=0, clo=0,rdo=0,cro=0 ,count=0;
        int row=matrix.length, col=matrix[0].length;

        while(count<row*col){
            if(rr){
                for(int i=clo; i<col-cro; i++){
                    count++;
                    matrix[ruo][i]=count;
                }
                rr=false;
                rl=false;
                cd=true;
                cu=false;
                ruo++;
                continue;
            }

            if(cd){
                for(int i=ruo; i<row-rdo; i++){
                    count++;
                    matrix[i][col-1-cro]=count;
                }
                rr=false;
                rl=true;
                cd=false;
                cu=false;
                cro++;
                continue;
            }

            if(rl){
                for(int i=col-1-cro; i>=clo; i--){
                    count++;
                    matrix[row-1-rdo][i]=count;
                }
                rr=false;
                rl=false;
                cd=false;
                cu=true;
                rdo++;
                continue;
            }

            if(cu){
                for(int i=row-1-rdo; i>=ruo; i--){
                    count++;
                    matrix[i][clo]=count;
                }
                rr=true;
                rl=false;
                cd=false;
                cu=false;
                clo++;
                continue;
            }
        }

        System.gc();
        return matrix;
    }
}
