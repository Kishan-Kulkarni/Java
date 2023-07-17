import java.util.*;

public class functionsPractice {
	public static void checkPrime(int n) {
		boolean isPrime = true;
		if (n == 1) {
			System.out.println("The number is neither prime or non prime");
			return;
		}

		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				isPrime = false;
				break;
			}
		}
		if (isPrime) {
			System.out.println("The number is prime");
		} else {
			System.out.println("The numner is non prime");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		checkPrime(n);
		sc.close();
	}

}
