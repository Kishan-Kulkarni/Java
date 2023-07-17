package Recursion;

import java.util.ArrayList;

public class printAllPaths {
    public static void main(String[] args) {
        System.out.println(printList(3,3, ""));
    }

    private static ArrayList<String> printList(int r, int c, String p) {
        if(r==1){
            for(int i=0; i<c-1; i++){
                p+="R";
            }
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }

        if(c==1){
            for(int i=0; i<r-1; i++){
                p+="D";
            }
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> down=printList(r-1, c, p+"D");
        ArrayList<String> right=printList(r, c-1, p+"R");

        down.addAll(right);

        return down;
    }
}
