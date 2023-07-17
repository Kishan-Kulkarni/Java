import java.util.*;


public class Arraylist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> list_2 = new ArrayList<>();
        
        list.add(69);
        list.add(300);
        list.add(-45);
        list.add(120);
        list.add(9495);
        list.add(320);

        System.out.println(list);
        System.out.println(list.contains(-45));
        System.out.println(list.get(2));

        for(int i=0; i<3; i++){
            list_2.add(new ArrayList<Integer>());
        }
        

        for(int i=0; i<3; i++){
            list_2.get(i).add(sc.nextInt());
        }
        sc.close();
        
    }
}
