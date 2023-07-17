package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class palindromePartitions {
    static List<List<String>> ans=new ArrayList<>();
    public static List<List<String>> partition(String s) {
        helper(s,"", new ArrayList<>());
        return ans;
    }
    public static void helper(String s, String p, List<String> list){
        if(s.isEmpty()){
            if(check(list)){
                ans.add(list);
            }
            return;
        }
        for(int i=1; i<=s.length(); i++){
            list.add(s.substring(0, i));
            helper(s.substring(i, s.length()),s, new ArrayList<>(list));
            list.remove(list.size()-1);
        }
        return ;
    }
    public static boolean check(List<String> list){
        for(int i=0; i<list.size(); i++){
            String s=list.get(i);
            for(int j=0; j<s.length()/2; j++){
                if(s.charAt(j)!=s.charAt(s.length()-j-1)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> ans=partition("aab");
        for(List<String> list : ans){
            System.out.println(list);
        }
    }
}
