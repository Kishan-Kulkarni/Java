import java.util.*;

public class Strings_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.close();
		String emailId = sc.nextLine();
		String userName = "";
		for (int i = 0; i < emailId.length(); i++) {
			if (emailId.charAt(i) == '@') {
				break;
			} else {
				userName += emailId.charAt(i);
			}
		}
		System.out.println(userName);
	}

}
