import java.util.Scanner;

public class Binaryoperators {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        boolean powerOf2 = false;
        for (int i = 0; i < 10; i++) {
            int bitmask = 1 << i;
            if (n == bitmask) {
                powerOf2 = true;
                break;
            }
        }
        if (powerOf2) {
            System.out.println("It is a power of 2");
        } else {
            System.out.println("It is not a power of 2");
        }

    }
}
