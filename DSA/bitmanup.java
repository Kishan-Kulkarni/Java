package DSA;
import java.util.*;
public class bitmanup {
public static void main(String[] args) {
    //Swapping 2 variables uing bits
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    a = a^b;
    b=a^b;
    a= a^b;
    System.out.println(a +" " + b);
    sc.close();
}
}
