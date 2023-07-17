package DSA;
import java.util.*;

public class numberconv{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a and b");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = (a^b);
        int count=0;
        int bits_in_c = ((int)(Math.log(c)/Math.log(2))+1);
        for(int i =0 ; i<=bits_in_c ; i++){
            int bitmask=1<<i;
            if((c&bitmask)!=0){
                count++;
            }
        }
        System.out.println(count);
        count=0;

        while(c>0){
            c=(c&(c-1));
            count++;
        }
        System.out.println(count);
        
        sc.close();

    }
}