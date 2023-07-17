import java.util.*;

public class arrays_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int[] orderCheck = new int[n];
		boolean asscending = true;
		for (int i = 0; i < n; i++) {
			orderCheck[i] = sc.nextInt();
		}
		for (int i = 0; i < n - 1; i++) {
			if (orderCheck[i] > orderCheck[i + 1]) {
				asscending = false;
				break;
			}
		}
		if (asscending) {
			System.out.println("It is in asscending order");
		} else {
			System.out.println("It is no in asscending order");
		}
	}

}
