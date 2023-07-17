import java.util.Scanner;

public class linearSearchLab {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        int[] arr=new int[n];

        System.out.println("Enter the elements of the array");

        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }

        System.out.println("Enter the element to be searched");

        int s=sc.nextInt();

        for (int i = 0; i < arr.length; i++) {
            if(s==arr[i]){
                System.out.println("The element was found at the " + i + "th index");
                if(i==0){
                    System.out.println("The time complexity is best for this case");
                }else if(i==arr.length-1){
                    System.out.println("The time complexity is the worst for this case");
                }else{
                    System.out.println("This case corresponds to average time complexity");
                }
            }
        }

        sc.close();
    }
}
