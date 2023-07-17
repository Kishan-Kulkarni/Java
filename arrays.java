import java.util.*;

public class arrays {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = sc.nextInt();
		}
		int x = sc.nextInt();
		for (int i = 0; i < n; i++) {
			if (numbers[i] == x) {
				System.out.println("the nuber is found at index " + i);
			}
		}

	}

}
