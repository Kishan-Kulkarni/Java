package DSA;
import java.util.*;
public class clearbit {
    public static void main(String[] args) {
        System.out.println("Please enter the number");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println("Please enter the position of the bit");
        int x = sc.nextInt();
        int bitmask = ~(1<<x);
        int new_a = a&bitmask;
        System.out.println("The new nuber is "+new_a);
        sc.close();
    }
}
