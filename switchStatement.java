import java.util.*;

public class switchStatement {

      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            String c = sc.next();

            switch (c) {
                  case "+":
                        double i = a + b;
                        System.out.println(i);
                        break;
                  case "-":
                        double x = a - b;
                        System.out.println(x);
                        break;
                  case "/":
                        double z = a / b;
                        System.out.println(z);
                        break;
                  case "*":
                        double y = a * b;
                        System.out.println(y);
                        break;
                  default:
                        System.out.println("Invalid Operator");
            }
            sc.close();
      }

}
