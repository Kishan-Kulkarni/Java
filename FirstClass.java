import java.util.*;

public class FirstClass {

	public static void main(String[] args) {
		System.out.println("Input your age");
		Scanner sc = new Scanner(System.in);
		sc.close();
		int age = sc.nextInt();
		if (age <= 18) {
			System.out.println("You are under age");
		} else {
			System.out.println("You are allowed");
		}
	}

}
