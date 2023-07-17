import java.util.HashMap;
import java.util.Map;

public class LeetCodeArrays {
    public static void main(String[] args) {
        int[][] matrix ={{0,1,1},{1,1,1},{1,1,1}};

        Map<String, String> memo=new HashMap<>();

        // for(int i=0; i<matrix.length; i++){
        //     for(int j=0; j<matrix[0].length; j++){
        //         if(matrix[i][j]==0){
        //             if(!(memo.containsKey("r"+Integer.toString(i)) || memo.containsValue("c" + Integer.toString(j)))){
        //                 makeZero(matrix, i ,j);
        //                 memo.put("r"+Integer.toString(i), "c" + Integer.toString(j));
        //             }
        //         }
        //     }

        // }

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]==0){
                    memo.put("r"+Integer.toString(i), "c" + Integer.toString(j));
                }
            }
        }

        System.out.println(memo);

        for(String key: memo.keySet()){
            makeZero(matrix, Character.getNumericValue(key.charAt(1)) , Character.getNumericValue(memo.get(key).charAt(1)));
        }

        for(int i=0; i<matrix.length; i++){
                for(int j=0; j<matrix[0].length; j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
        }
    }

    public static void makeZero(int[][] matrix, int i, int j) {
        for(int k=0; k<matrix.length; k++){
            matrix[k][j]=0;
        }

        for(int k=0; k<matrix[0].length; k++){
            matrix[i][k]=0;
        }
    }
}
