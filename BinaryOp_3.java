import java.util.*;

public class BinaryOp_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int numberOfOne = 0;
        for (int i = 0; i <= 10; i++) {
            int bitMask = 1 << i;
            if ((n & bitMask) != 0) {
                numberOfOne++;
            }
        }
        System.out.println("The nimber of ones are " + numberOfOne);
    }
}
