public class powerWithBinary {
    public static void main(String[] args){
        int base=3;
        int n=6;

        while(n>0){
            if((n&1)==1){
                base*=base;
            }
            n=n>>1;
        }

        System.out.println(base);
    }
}
