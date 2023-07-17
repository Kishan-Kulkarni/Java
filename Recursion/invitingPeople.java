package Recursion;

public class invitingPeople {
    public static void main(String[] args) {
        int n=4;
        System.out.println(partyInvitation(n));
    }

    private static int partyInvitation(int n) {
        if(n==1 || n==0){
            return 1;
        }

        return partyInvitation(n-1)+(n-1)*partyInvitation(n-2);
    }
}
