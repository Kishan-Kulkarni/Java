import java.util.*;

public class Strings_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.close();
		String activity = sc.nextLine();
		char change = 'e';
		char changeTo = 'i';
		String result = "";
		for (int i = 0; i < activity.length(); i++) {
			if (activity.charAt(i) == change) {
				result += changeTo;
			} else {
				result += activity.charAt(i);
			}
		}
		System.out.println(result);
	}

}
