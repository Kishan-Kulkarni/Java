import java.util.ArrayList;
import java.util.Arrays;


public class missinglist {
    public static void main(String[] args) {
        int arr[]={4,3,2,7,8,2,3,1};

        int i=0; 
        while(i<arr.length){
            int correct=arr[i]-1;
            
            if(arr[i]!=arr[correct]){
                int temp= arr[i];
                arr[i]=arr[correct];
                arr[correct]=temp;
            }else{
                i++;
            }
        }

        ArrayList<Integer> result=new ArrayList<Integer>();
        for(int idx=0; idx<arr.length; idx++){
            if(arr[idx]!=idx+1){
                result.add(idx+1);
            }
        }

        System.out.println(Arrays.toString(arr));
        
        for(int idx=0; idx<result.size(); idx++){
            System.out.print(result.get(idx) + " ");
        }
    }
}
