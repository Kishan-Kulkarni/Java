package LeetCode.LinkedList;

public class deleteElem {
    public static ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return null;
        }
        if(head.next==null && head.val==val){
            return null;
        }
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null){
            if(temp==head){
                if(temp.val==val){
                    head=temp.next;
                    temp=head;
                    continue;
                }
            }else{
                if(temp.val==val){
                    prev.next=temp.next;
                    temp=prev.next;
                    continue;
                }
            }
            if(prev==null){
                prev=head;
            }else{
                prev=prev.next;
            }
            temp=temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode temp=head;
        int[] values={2,1};
        for(int i:values){
            ListNode curr=new ListNode(i);
            temp.next = curr;
            temp=curr;
        }
        head=removeElements(head, 1);

    }
}
