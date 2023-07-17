import java.util.*;

public class RREF_Elective {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n, m;
        System.out.println("Please enter the number of rows:");
        n=sc.nextInt();
        System.out.println("Please enter the number of columns:");
        m=sc.nextInt();
        float[][] arr=new float[n][m];




        System.out.println("Please enter the elements of the array:");

        for (int i = 0; i < n;i++) {
            for(int j=0; j<m; j++){
                arr[i][j]=sc.nextInt();
            }
        }

        reduceRowForm(arr);

        for(float[] i:arr){
            System.out.println(Arrays.toString(i));
        }


    }

    public static void reduceRowForm(float[][] arr) {
        //Checking if there are zero rows and swapping them with last rows

        int zero_rows=arr.length-1;

        boolean consecZeroRows=true;
        for(int i= arr.length-1; i>=0; i--){
            for(int j=0; j < arr[i].length; j++){
                if(arr[i][j]!=0){
                    consecZeroRows=false;
                    break;
                }
            }
            if(!consecZeroRows){
                break;
            }else{
                zero_rows--;
            }
        }

        for(int i=0; i<arr.length-1; i++){
            boolean allZeroes=true;
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j]!=0){
                    allZeroes = false;
                    break;
                }
            }
            if(allZeroes){
                swap_rows(arr,i, zero_rows--);
            }
        }

        //Checking if the first element of the first row is non-zero
        int next_row=1;
        while(arr[0][0]==0){
            for(int i=0; i<arr[0].length; i++){
                float temp=arr[0][i];
                arr[0][i]=arr[next_row][i];
                arr[next_row][i]=temp;

            }
            next_row++;
        }

        //Applying the appropriate row transforms to gor into the reduced row form
        for(int i=0; i<arr.length; i++){

            int first_non_zero=0;
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j]==0){
                    first_non_zero++;
                }else{
                    break;
                }
            }

            if(first_non_zero==arr[0].length){
                continue;
            }

            float factor=arr[i][first_non_zero];

            for(int j=0; j<arr[0].length; j++){
                arr[i][j]=arr[i][j]/factor;

            }

            subtract_row(arr, i, first_non_zero);

            for(int j=0; j<arr.length; j++){
                for(int k=0; k<arr[j].length; k++){
                    if(Math.abs(arr[j][k])<1e-6){
                        arr[j][k] = 0.0f;
                    }
                }
            }
        }
    }

    private static void subtract_row(float[][] arr, int i, int first_non_zero) {

        for(int j=0; j<arr.length; j++){
            float factor=arr[j][first_non_zero];
            for(int k=0;k < arr[0].length; k++){
                if(i==j){
                    break;
                }
                arr[j][k]=arr[j][k]-arr[i][k]*factor;

            }
        }

        for(int j=0; j<arr.length; j++){
            for(int k=0; k<arr[j].length; k++){
                if(Math.abs(arr[j][k])<1e-6){
                    arr[j][k] = 0.0f;
                }
            }
        }
    }

    public static void swap_rows(float[][] arr, int i, int zero_rows) {

        for(int j=0; j<arr[0].length;j++){
            float temp=arr[i][j];
            arr[i][j] = arr[zero_rows][j];
            arr[zero_rows][j] = temp;


        }

    }
}
