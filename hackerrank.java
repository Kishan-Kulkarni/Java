import java.util.*;

public class hackerrank {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String S1 = sc.next();
		int N1 = sc.nextInt();
		sc.nextLine();
		String S2 = sc.next();
		int N2 = sc.nextInt();
		sc.nextLine();
		String S3 = sc.next();
		int N3 = sc.nextInt();
		while (S1.length() <= 15) {
			S1 = S1 + " ";
		}
		while (S2.length() <= 15) {
			S2 = S2 + " ";
		}
		while (S3.length() <= 15) {
			S3 = S3 + " ";
		}

		System.out.println("================================");
		if (N1 < 100) {
			if (N1 < 10) {
				System.out.println(S1 + "00" + N1);
			} else {
				System.out.println(S1 + "0" + N1);
			}
		} else {
			System.out.println(S1 + N1);
		}
		if (N2 < 100) {
			if (N2 < 10) {
				System.out.println(S2 + "00" + N2);
			} else {
				System.out.println(S2 + "0" + N2);
			}
		} else {
			System.out.println(S2 + N2);
		}
		if (N3 < 100) {
			if (N3 < 10) {
				System.out.println(S3 + "00" + N3);
			} else {
				System.out.println(S3 + "0" + N3);
			}
		} else {
			System.out.println(S3 + N3);
		}
		System.out.println("================================");
		sc.close();

	}

}
