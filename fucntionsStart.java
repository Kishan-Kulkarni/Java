import java.util.*;

public class fucntionsStart {
	public static int calculateProduct(int a, int b) {
		int product = a * b;
		return product;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.close();
		int a = sc.nextInt();
		int b = sc.nextInt();

		int product = calculateProduct(a, b);
		System.out.println(product);
	}

}
