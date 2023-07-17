import java.util.HashSet;
import java.util.Scanner;

public class olfhnwi{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int q=sc.nextInt();
        HashSet<Integer> set=new HashSet<>();
        while(q>0){
            int l=sc.nextInt();
            int r=sc.nextInt();
            if(r-l+1==n){
                System.out.println(n);
                return;
            }
            for(int i=l; i<=r; i++){
                set.add(i);
            }
            
            q--;
        }
        
        System.out.println(set.size());
        sc.close();
    }

    // int[] l=new int[q];
        // int[] r=new int[q];
        // int i=0;
        // while(q-->0){
            
        //     int li=sc.nextInt();
        //     int ri=sc.nextInt();
        //     l[i]=li;
        //     r[i]=ri;
        //     i++;
        // }

        // int min=Integer.MAX_VALUE;
        // for(int j=0; j<l.length; j++){
        //     if(l[j]<min){
        //         min=l[j];
        //     }
        // }

        // int max=Integer.MIN_VALUE;

        // for(int j=0; j<r.length; j++){
        //     if(l[j]>max){
        //         max=l[j];
        //     }
        // }
}