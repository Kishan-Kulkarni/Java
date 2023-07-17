public class rightsetbit{
    public static void main(String[] args) {
        int n=8;
        System.out.println(printsetbit(n));
    }

    private static int printsetbit(int n) {
        if(n==0) return 0;

        for(int i=0; i<Math.log(n)/Math.log(2) +1; i++){
            int bitmask=1<<i;
            if((bitmask&n)!=0){
                return i+1;
            }
        }
        return -1;
    }
}                                                          