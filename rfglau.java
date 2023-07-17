import java.util.HashMap;
import java.util.Scanner;

public class rfglau {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        while(t-->0){
            int n=sc.nextInt();
            HashMap<Integer, Integer> map=new HashMap<>();
            createMap(map, n);

            int m=sc.nextInt();
            while(m-->0){
                int u=sc.nextInt();
                int v=sc.nextInt();

                if(map.get(u)>map.get(v)){
                    int a=map.get(u);
                    int b=map.get(v);

                    map.put(u, b);
                    map.put(v,a);
                }
            }

            int[] arr=new int[n];

            for(int i=0; i<n; i++){
                arr[map.get(i)]=i;
            }

            for(int i=0; i<arr.length; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public static void createMap(HashMap<Integer, Integer> map, int n) {
        for(int i=0; i<n; i++){
            map.put(i, i);
        }
    }
}
