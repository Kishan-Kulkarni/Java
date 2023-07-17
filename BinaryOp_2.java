import java.util.*;

public class BinaryOp_2 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      sc.close();
      int pos = sc.nextInt();
      int bitMask = 1 << pos;
      int verify = n & bitMask;
      int result;
      int notBitMask = ~(bitMask);
      if (verify == 0) {
         result = n | bitMask;
      } else {
         result = n & notBitMask;
      }
      System.out.println(result);

   }
}
