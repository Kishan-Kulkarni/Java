import java.util.*;

public class Loops {

	public static void main(String[] args) {
		// For Loops
		// for(int i =1 ;i<101 ; i++) {
		// System.out.println("Hello World");
		// }
		// for(int i =1 ; i<11 ; i++) {
		// System.out.print(i +" ");
		// }

		// While Loops
		// int i =0;
		// while(i<11) {
		// System.out.println(i);
		// i++;
		// }

		// Do-While Loop //These run atleast once i.e first there is intialisation
		// without checking condition then for every term the condition is checked
		// int i=0;
		// do {
		// System.out.println(i);
		// i++;
		// }while(i<11);
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		for (int i = 1; i < n + 1; i++) {
			sum = sum + i;
		}
		System.out.println(sum);
		sc.close();
	}

}
