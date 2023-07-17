import java.util.*;

public class Hackerrank_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        sc.close();
        int n = A.length() + B.length();
        System.out.println(n);

        if (A.compareTo(B) > 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        String a = A.substring(0, 1);
        String b = B.substring(0, 1);
        String remain_a = A.substring(1, A.length());
        String remain_b = B.substring(1, B.length());
        a = a.toUpperCase();
        b = b.toUpperCase();
        A = a + remain_a;
        B = b + remain_b;
        System.out.println(A);
        System.out.println(B);

    }
}
