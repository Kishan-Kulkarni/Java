public class maxRepeatingString {
    public static void main(String[] args) {
        System.out.println(maxRepeating("ababcabababab", "ab"));
    }

    static int maxRepeating(String sequence, String word) {
        int k=0; 
        int max=k;
    
        for(int i=0; i<sequence.length()-word.length(); i+=word.length()){
            if(sequence.substring(i, i+word.length()).equals(word)){
                k++;
                max=k;
            }else{
                k=0;
            }
        }

        return max;
    }
}
