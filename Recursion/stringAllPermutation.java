package Recursion;

import java.util.ArrayList;

public class stringAllPermutation {
    public static void main(String[] args) {
        String a = "abc";
        // printAllPermutations(a, "");
        System.out.println(printAllPermutationsArrayList(a, ""));

    }

    static void printAllPermutations(String a, String b) {
        if (a.isEmpty()) {
            System.out.println(b);
            return;
        }

        char ch = a.charAt(0);
        for (int i = 0; i <= b.length(); i++) {
            String f = b.substring(0, i);
            String s = b.substring(i);
            printAllPermutations(a.substring(1), f + ch + s);
        }
    }

    static ArrayList<String> printAllPermutationsArrayList(String a, String b) {
        if (a.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(b);
            return list;
        }

        ArrayList<String> ans = new ArrayList<>();

        char ch = a.charAt(0);
        for (int i = 0; i <= b.length(); i++) {
            String f = b.substring(0, i);
            String s = b.substring(i, b.length());
            ans.addAll(printAllPermutationsArrayList(a.substring(1), f + ch + s));
        }

        return ans;
    }
}
