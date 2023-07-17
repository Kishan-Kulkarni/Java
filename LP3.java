
public class LP3 {

	public static void main(String[] args) {
		for(int i=1 ; i<6 ; i++) {
			for(int j=1 ; j<6 ; j++) {
				if(i>=j) {
					System.out.print(j);
				}else {
					System.out.print(" ");
				}
			}System.out.println();
		}
		for(int i=1 ; i<6 ; i++) {
			for(int j=1 ; j<6 ; j++) {
				if(j<=6-i) {
					System.out.print(j);
				}else {
					System.out.print(" ");
				}
			}System.out.println();
		}
	   int f =1;
	   for(int i=1 ; i<6 ; i++) {
			for(int j=1 ; j<6 ; j++) {
				if(i>=j) {
					System.out.print(f);
					f++;
				}else {
					System.out.print(" ");
				}
			}System.out.println();
		}
	    for(int i =1; i<6 ; i++) {
	    	for(int j=1 ; j<6 ; j++) {
	    		if(i>=j) {
	    			if((i + j)%2==0) {
	    				System.out.print("1");
	    			}else {
	    				System.out.print("0");
	    			}
	    		}else {
	    			System.out.print(" ");
	    		}
	    	}System.out.println();
	    }
	
	}
	

}
