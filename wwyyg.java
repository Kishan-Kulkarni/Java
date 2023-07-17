import java.util.Scanner;

public class wwyyg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int q=sc.nextInt();

        

        int[] arr=new int[n];

        for(int i=0; i<n; i++){
            arr[i]=i+1;
        }

        int low=Integer.MAX_VALUE; 
        int high=Integer.MIN_VALUE;

        while(q-->0){
            int l=sc.nextInt();
            int r=sc.nextInt();

            if(l<low){
                low=l;
            }

            if(high>r){
                high=r;
            }
        }

        System.out.println(high-low+1);
    }
}
