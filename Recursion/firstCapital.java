package Recursion;

public class firstCapital {
    public static void main(String[] args) {
        printCapital("geeksforgeeKs");
    }

     static void printCapital(String a) {
        if(a.isEmpty()){
            System.out.println("There are no capital letters in the string");
            return;
        }

        char ch=a.charAt(0);
        if(ch>='A' && ch<='Z'){//Use Character.isUppercase(ch) instead of these inequlities
            System.out.println(ch);
            return;
        }else{
            printCapital(a.substring(1));
        }
    }
}
