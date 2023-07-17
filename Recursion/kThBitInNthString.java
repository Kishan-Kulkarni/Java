package Recursion;

public class kThBitInNthString {

    public static String toString(char arr[]) {
        String string = new String(arr);
 
        return string;
    }

    public static void main(String[] args) {
        System.out.println(findKthBit(4, 3));
        System.out.println(getNthString("0", 3));
     
    }
    public static char findKthBit(int n, int k) {
        if(k==0){
            return '0';
        }
        
        String s="0";
        // for(int i=0; i<n; i++){
        //     s=(s+'1').concat(rev(inverse(s)));
        // }

        String ans=getNthString(s, 3);

        return ans.charAt(k);
    }
    private static String getNthString(String s, int n) {
        if(n==1){
            return s;
        }

        // s=(s+'1').concat(rev(inverse(s)));
        s=s+'1'+rev(inverse(s));
       return getNthString(s, n-1);
    }
    private static String rev(String s) {
        char[] sArr= s.toCharArray();

        for(int i=0; i<sArr.length/2; i++){
            char temp=sArr[i];
            sArr[i]=sArr[sArr.length-1-i];
            sArr[sArr.length-1-i]=temp;
        }
        return toString(sArr);
    }
    private static String inverse(String s) {
        char[] sArr= s.toCharArray();

        for(int i=0 ; i<sArr.length; i++){
            if(sArr[i]=='1'){
                sArr[i]='0';
            }else{
                sArr[i]='1';
            }
        }

        return toString(sArr);
    }
}
