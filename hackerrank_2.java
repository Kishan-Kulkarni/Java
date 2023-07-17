import java.util.*;

public class hackerrank_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();

        for (int i = 1; i <= q; ++i) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int n = sc.nextInt();
            int sum = a;
            int temp = b;

            for (int k = 0; k < n; k++) {
                sum += temp;
                temp *= 2;
                System.out.print(sum + " ");
            }
            System.out.println();

        }
        sc.close();

    }
}
