import java.util.Scanner;

public class frhla {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        while(t-->0){
            int n=sc.nextInt();
            int keys[]=new int[n];
            for(int i=0; i<n; i++){
                keys[i]=i;
            }

            int m=sc.nextInt();
            while(m-->0){
                int u=sc.nextInt();
                int v=sc.nextInt();
                int i=binarySearch(keys, u);
                int j=binarySearch(keys, v);

                if(i!=-1 || j!=-1){
                    int temp=keys[i];
                    keys[i]=keys[j];
                    keys[j]=temp;
                }

                
            }
        }
    }

    private static int binarySearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==target){
                return i;
            }
        }
        return -1;
    }
}
