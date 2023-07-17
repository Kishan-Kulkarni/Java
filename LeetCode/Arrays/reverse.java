package LeetCode.Arrays;

public class reverse {
    public static void main(String[] args) {
        System.out.println(reverseWord("Geeks"));
    }
    public static String reverseWord(String s){
        char[] ch=s.toCharArray();
        for(int i=0; i< ch.length/2; i++){
            char t=ch[i];
            ch[i]=ch[ch.length-1-i];
            ch[ch.length-1-i]=t;
        }
        return new String(ch);
    }
}
