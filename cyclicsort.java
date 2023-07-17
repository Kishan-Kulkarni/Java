import java.util.Arrays;

public class cyclicsort {
    public static void main(String[] args) {
        int arr[] = { 3, 0, 1, 2 };

        int i = 0;
        // while(i<arr.length){
        // int correct=arr[i]-1;
        // if(arr[i]!=arr[correct]){
        // int temp=arr[i];
        // arr[i]=arr[correct];
        // arr[correct]=temp;
        // }else{
        // i++;
        // }
        // }

        while (i < arr.length) {
            if (arr[i] < arr.length) {
                int correct = arr[i];
                if (arr[i] != arr[correct]) {
                    int temp = arr[i];
                    arr[i] = arr[correct];
                    arr[correct] = temp;
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
