public class rightmostsetbit {
    public static void main(String[] args) {
        int n=40;
        System.out.println(setbitindex(n));

    }

    private static int setbitindex(int n) {
        int found=-1;
        for(int i=0; i<Math.log10(n); i++) {
            n=n>>i;
            if((n&1)==1){
                found =i+1;
                break;
            }

        }
        return found;
    }
}
