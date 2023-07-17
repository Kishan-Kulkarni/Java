import java.util.Scanner;
import java.util.Stack;

public class linearSeachStackLab {
    public static void main(String[] args) {
        Stack<Integer> st=new Stack<>();

        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        for (int i = 0; i < n; i++) {
            st.push(sc.nextInt());
        }

        int search=sc.nextInt();

        int i=0;

        while(!st.empty()){
            if(st.pop()==search){
                System.out.println("The element was found at the " + i + "th index");
                if(i==0){
                    System.out.println("The time complexity is best for this case");
                }else if(i==n-1){
                    System.out.println("The time complexity is the worst for this case");
                }else{
                    System.out.println("This case corresponds to average time complexity");
                }
            }

            i++;
            }


            sc.close();
        }
        
    }

