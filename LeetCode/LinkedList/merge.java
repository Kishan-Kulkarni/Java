package LeetCode.LinkedList;

import java.util.LinkedList;
import java.util.Queue;

public class merge {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        Queue<ListNode> queue = new LinkedList<>();
        ListNode newHead=new ListNode();
        ListNode temp=newHead;
        ListNode temp1=list1;
        ListNode temp2=list2;
        while(temp1!=null && temp2!=null){
            if(temp1.val<temp2.val){
                temp.val=temp1.val;
                ListNode newTemp=new ListNode();
                temp.next=newTemp;
                temp1=temp1.next;
                temp=newTemp;
            }else{
                temp.val=temp2.val;
                ListNode newTemp=new ListNode();
                temp.next=newTemp;
                temp2=temp2.next;
                temp=newTemp;
            }
        }
        while(temp1!=null){
            temp.val=temp1.val;
            if(temp1.next==null){
                break;
            }
            ListNode newTemp=new ListNode();
            temp.next=newTemp;
            temp1=temp1.next;
            temp=newTemp;
        }
        while(temp2!=null){
            temp.val=temp2.val;
            if(temp2.next==null){
                break;
            }
            ListNode newTemp=new ListNode();
            temp.next=newTemp;
            temp2=temp2.next;
            temp=newTemp;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head1=new ListNode(1);
        ListNode temp=head1;
        int[] values={2,4};
        for(int i:values){
            ListNode curr=new ListNode(i);
            temp.next = curr;
            temp=curr;
        }
        ListNode head2=new ListNode(1);
        temp=head2;
        int[] values2={3,4};
        for(int i:values2){
            ListNode curr=new ListNode(i);
            temp.next = curr;
            temp=curr;
        }
        ListNode newHead=mergeTwoLists(head1, head2);
    }
}
