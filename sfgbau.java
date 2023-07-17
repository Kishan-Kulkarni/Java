import java.util.Scanner;

public class sfgbau {
    public static void main(String[] args) {
        float x=1000000007;
        int T;
        Scanner sc =new Scanner(System.in);
        T=sc.nextInt();

        while(T-->0){
            int n=sc.nextInt();
            int k=0;

            StringBuilder str=new StringBuilder();

            while(4*k+1<=n){
                str.append(Integer.toString(4*k+1));
                k++;
            }

            System.out.println((int)(str.length()%x));
        }
    }
}
