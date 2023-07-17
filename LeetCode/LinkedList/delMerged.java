package LeetCode.LinkedList;

public class delMerged {
    public static ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode temp=head;
        while(temp!=null && temp.next!=null){
            if(temp.val==temp.next.val){
                temp.next=temp.next.next;
            }else{
            temp=temp.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode temp=head;
        int[] values={1,1};
        for(int i:values){
            ListNode curr=new ListNode(i);
            temp.next = curr;
            temp=curr;
        }
        head=deleteDuplicates(head);
    }
}
