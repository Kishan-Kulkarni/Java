
public class advLP2 {

	public static void main(String[] args) {
		int f =1;
		
		for(int i =1 ; i<6 ; i++) {
			
			for(int j =1 ; j<=9 ; j++) {
				if(j==6-i || j==4+i) {
					
					System.out.print(f);
					
				}else {
					System.out.print(" ");
				}
				  
			}System.out.println();
			++f;
		}	

	}

}
