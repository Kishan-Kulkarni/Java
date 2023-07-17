import java.util.*;

public class aarays_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int comparision[] = new int[n];

		for (int i = 0; i < n; i++) {
			comparision[i] = sc.nextInt();
		}
		int smallest = comparision[0];
		int largest = comparision[0];

		for (int i = 1; i < n; i++) {
			if (comparision[i] < smallest) {
				smallest = comparision[i];
			} else if (comparision[i] > largest) {
				largest = comparision[i];
			}
		}

		System.out.println(largest + " " + smallest);
		sc.close();
	}

}
