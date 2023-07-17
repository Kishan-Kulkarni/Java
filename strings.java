import java.util.*;

public class strings {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.close();
		String[] random = new String[3];

		for (int i = 0; i < 3; i++) {
			random[i] = sc.nextLine();
		}

		int combinedLenght = 0;
		for (int i = 0; i < 3; i++) {
			combinedLenght = combinedLenght + random[i].length();
		}
		System.out.println(combinedLenght);
		// name.lenght()
		// name.charAt(i)
		// name1.compareTo(name2) Comparison happens at the first point of difference
		// the String with letter more farther than "a" at that point of difference is
		// considered to be greater
		// name.substring(beginning index , ending index)
		// Strings are Immutable
	}

}
