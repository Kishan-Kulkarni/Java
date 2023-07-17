import java.util.ArrayList;
import java.util.List;

public class pascalTriangle {
    public static List<List<Integer>> getPascal(int n){
            if(n==1){
                List<List<Integer>> list=new ArrayList<>();
                List<Integer> temp=new ArrayList<>();
                temp.add(1);
                list.add(temp);
                return list;
            }
            List<List<Integer>> prevRows=getPascal(n-1);
            List<Integer> prev=prevRows.get(prevRows.size() - 1);
             List<Integer> curr=new ArrayList<>();
             curr.add(1);
             for(int i=0; i<prev.size()-1;i++){
                 curr.add(prev.get(i)+prev.get(i+1));
             }
             curr.add(1);
             prevRows.add(curr);
             return prevRows;
    }

    public static void main(String[] args) {
        List<List<Integer>> list=getPascal(20);
        for(List<Integer> i:list){
            System.out.println(i);
        }
    }
}
