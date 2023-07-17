package LeetCode.LinkedList;

public class isPalindrome {
    public boolean isPalindrome(ListNode head) {
        if(head.next==null){
            return true;
        }
        int size=0;
        ListNode temp=head;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        int mid=size/2;
        temp=head;
        for(int i=0; i<mid-1; i++){
            temp=temp.next;
        }
        temp.next=reverseMid(temp.next);
        temp=head;
        for(int i=0; i<mid; i++){
            temp=temp.next;
        }
        ListNode check=head;
        for(int i=0; i<mid; i++){
            if(check.val!=temp.val){
                return false;
            }
            check=check.next;
            temp=temp.next;
        }
        return true;
    }
    public ListNode reverseMid(ListNode head){
        if(head==null){
            return head;
        }
        if(head.next==null){
            return head;
        }
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode temp=head;
        int[] values={1,2,1};
        for(int i:values){
            ListNode curr=new ListNode(i);
            temp.next = curr;
            temp=curr;
        }
        System.out.println(new isPalindrome().isPalindrome(head));
    }
}
