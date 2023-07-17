public class isPanagram{
    
    public static void main(String[] args) {
        String sentence="thequickbrownfoxjumpsoverthelazydog";
        char check='a';
        
        boolean isPan =false;
        for(int i=0; i<sentence.length(); i++){
            for(int j=0; j<sentence.length(); j++){
                if(sentence.charAt(j)==check){
                    isPan=true;
                    break;
                }else{
                    isPan=false;
                }
            }
            check++;
            if(!isPan){
                break;
            }
        }
        System.out.println(isPan);
    }
}
