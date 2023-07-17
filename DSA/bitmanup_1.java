package DSA;
import java.util.*;
public class bitmanup_1 {
    public static void main(String[] args){
        System.out.println("Please enter the number");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println("Please enter the position of the bit");
        int x = sc.nextInt();
        int bitmask = 1<<x;
        if((a&bitmask)==0){
            System.out.println("The bit is a 0");
        }else{
            System.out.println("The bit is a 1");
        }
        sc.close();
    }
}
