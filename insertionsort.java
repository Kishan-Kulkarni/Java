import java.util.*;
public class insertionsort {
   
    public static void main(String[] args) {
        
        int arr[]={3,-11,0,5,-21};

        for(int i=0; i<arr.length-1; i++) {
            for(int j=i+1; j>0; j--) {
                if(arr[j]<arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1]=temp;
                }else{
                    break;
                }
            }       
        }

        
        System.out.println(Arrays.toString(arr));
    }
}
