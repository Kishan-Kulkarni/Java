package Recursion;

import java.util.ArrayList;

public class letterCombination {

    public static ArrayList<String> allCombinations(String digits){
        if(digits.isEmpty()){
            return new ArrayList<>();
        }

    if((digits.charAt(0)-'0')<9 && (digits.charAt(0)-'0')!=7){
            ArrayList<String> list= new ArrayList<>();
            list.add(specialAdd(digits.charAt(0), 1));
            ArrayList<String> list1=allCombinations(digits.substring(1));
            list.add(specialAdd(digits.charAt(0), 2));
            ArrayList<String> list2=allCombinations(digits.substring(1));
            list.add(specialAdd(digits.charAt(0), 3));
            ArrayList<String> list3=allCombinations(digits.substring(1));
            list1.addAll(list2);
            list3.addAll(list1);
            list.addAll(list3);
            return list;
        }else{
            ArrayList<String> list=new ArrayList<>();
            list.add(specialAdd(digits.charAt(0), 1));
            ArrayList<String> list1=allCombinations(digits.substring(1));
            list.add(specialAdd(digits.charAt(0), 2));
            ArrayList<String> list2=allCombinations(digits.substring(1));
            list.add(specialAdd(digits.charAt(0), 3));
            ArrayList<String> list3=allCombinations(digits.substring(1));
            list.add(specialAdd(digits.charAt(0), 4));
            ArrayList<String> list4 =allCombinations(digits.substring(1));
            list1.addAll(list2);
            list3.addAll(list1);
            list4.addAll(list3);
            list.addAll(list4);
            return list;
        }
    }        

    private static String specialAdd(char c, int i) {
        if(c=='2' && i==1){
            return "a";
        }
        if(c=='2' && i==2){
            return "b";
        }
        if(c=='2' && i==3){
            return "c";
        }
        if(c=='3' && i==1){
            return "d";
        }
        if(c=='3' && i==2){
            return "e";
        }
        if(c=='3' && i==3){
            return "f";
        }
        if(c=='4' && i==1){
            return "g";
        }
        if(c=='4' && i==2){
            return "h";
        }
        if(c=='4' && i==3){
            return "i";
        }
        if(c=='5' && i==1){
            return "j";
        }
        if(c=='5' && i==2){
            return "k";
        }
        if(c=='5' && i==3){
            return "l";
        }
        if(c=='6' && i==1){
            return "m";
        }
        if(c=='6' && i==2){
            return "n";
        }
        if(c=='6' && i==3){
            return "o";
        }
        if(c=='7' && i==1){
            return "p";
        }
        if(c=='7' && i==2){
            return "q";
        }
        if(c=='7' && i==3){
            return "r";
        }
        if(c=='7' && i==4){
            return "s";
        }
        if(c=='8' && i==1){
            return "t";
        }
        if(c=='8' && i==2){
            return "u";
        }
        if(c=='8' && i==3){
            return "v";
        }
        if(c=='9' && i==1){
            return "w";
        }
        if(c=='9' && i==2){
            return "x";
        }
        if(c=='9' && i==3){
            return "y";
        }
        if(c=='9' && i==4){
            return "z";
        }
        
        return null;
    }

    public static ArrayList<String> betterSolution(String digits){
        return helper(digits, new String("")) ;
    }
    private static ArrayList<String> helper(String digits, String p) {
        ArrayList<String> list= new ArrayList<>();
        if(digits.isEmpty()){
            ArrayList<String> list1= new ArrayList<>();
            list1.add(p);
            return list1;
        }

        char ch = digits.charAt(0);
        for(int i=((ch-'0')-1)*3; i<((ch-'0')*3); i++){
            if(i!=26)
                list.addAll(helper(digits.substring(1), (p+((char)('a'+i)))));
        }

        return list;

    }

    public static void main(String[] args) {
       System.out.println(betterSolution("12"));
    }
}
