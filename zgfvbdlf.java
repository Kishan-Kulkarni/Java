import java.util.ArrayList;
import java.util.Scanner;

public class zgfvbdlf {
    public static void main(String[] args) {
        float x=1000000007;
        Scanner sc=new Scanner(System.in);

        int t=sc.nextInt();

        while(t-->0){
            String s=sc.next();
            sc.nextLine();
            int p=sc.nextInt();

            ArrayList<String> all= subseqRet("", s);

            float sum=0;

            for(int i=0; i<all.size(); i++){
                String str=all.get(i);
                for(int j=0; j<str.length(); j++){
                    sum+=(str.charAt(j)-'a');
                }
                sum*=Math.pow(p, str.length());
                sum=(int)sum%x;
            }

            System.out.println(sum);
        }
    }

    static ArrayList<String> subseqRet(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = subseqRet(p + ch, up.substring(1));
        ArrayList<String> right = subseqRet(p, up.substring(1));

        left.addAll(right);
        return left;
    }
}
