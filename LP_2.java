
public class LP_2 {

	public static void main(String[] args) {
		for(int i=1 ; i<5 ; i++) {
			for(int j=1 ; j<5 ; j++) {
				if(i>=j) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}System.out.println();
		} 
         //Second Method 
	   for(int i =1 ; i<5 ; i++) {
		   for( int j = 1 ; j<=i ; j++) {
			   System.out.print("*");
		   }System.out.println();
			   
	   }
	  
	    
	   for(int i =4 ; i>0 ; i--) {
		   for( int j = 1 ; j<=i ; j++) {
			   System.out.print("*");
		   }System.out.println();
			   
	   }
	   for(int i=1 ; i<5 ; i++) {
			for(int j=1 ; j<5 ; j++) {
				if(i>4-j) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}System.out.println();
		} 
	}
	

}
