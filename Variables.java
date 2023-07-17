import java.util.*;

public class Variables {

	public static void main(String[] args) {
		System.out.println("Pleae enter dia");
		Scanner sc = new Scanner(System.in);
		double dia = sc.nextDouble();
		double radius = dia / 2;
		double circumference = 2 * 3.14 * radius;
		double area = 3.14 * radius * radius;
		System.out.println("Hence the circumference is" + circumference);
		System.out.print("Hence the area is" + area);
		sc.close();
	}

}
