package DSA;

import java.util.LinkedList;
import java.util.Queue;

public class binaryTrees1 {

    static int index=-1;
    public static class Node{
        Integer val;
        Node right;
        Node left;

        public Node(int val, Node right, Node left) {
            this.val = val;
            this.right = right;
            this.left = left;
        }

        public Node(int val) {
            this.val = val;
        }

        public Node() {
        }
    }

    public Node insertArrayElements(int[] arr){
        index++;

        if(index<arr.length && arr[index]==-1)
            return null;

        Node newNode=new Node(arr[index]);
        newNode.left=insertArrayElements(arr);
        newNode.right = insertArrayElements(arr);

        return newNode;
    }

    public void levelOrder(Node head){
        Queue<Node> q=new LinkedList<>();
        q.add(head);
        q.add(null);

        while(!q.isEmpty()){
            Node currNode=q.remove();
            if(currNode==null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(currNode.val + " ");
                if(currNode.left!=null){
                    q.add(currNode.left);
                }
                if(currNode.right!=null){
                    q.add(currNode.right);
                }
            }
        }
    }

    public int countNodes(Node head){
        if(head==null){
            return 0;
        }
        int count=0;

        count =1+countNodes(head.left)+countNodes(head.right);

        return count;
    }

    public int sumNodes(Node head){
        if(head==null || head.val==null){
            return 0;
        }

        return head.val+ sumNodes(head.left)+sumNodes(head.right);
    }



    public int heightTree(Node head, int currHeight){

        if(head==null){
            return 0;
        }

        return Math.max(heightTree(head.right, currHeight+1)+1, heightTree(head.left, currHeight+1)+1);
    }

    public int diameterTree(Node head){
        if(head==null){
            return 0;
        }

        return Math.max(deepestLeft(head)+deepestRight(head)-1, Math.max(diameterTree(head.right), diameterTree(head.left)));
    }

    private int deepestRight(Node head) {
        if(head == null){
            return 0;
        }

       if(head.right == null){
           return 1+deepestRight(head.left);
       }

       return 1+deepestRight(head.right);
    }

    private int deepestLeft(Node head) {
        if(head == null){
            return 0;
        }

        if(head.left == null){
            return 1+deepestRight(head.right);
        }

        return 1+deepestRight(head.left);
    }

    public static void main(String[] args) {
        binaryTrees1 bt=new binaryTrees1();
        Node head=bt.insertArrayElements(new int[]{25,15,10,4,-1,-1,12,-1,-1,22,18,-1,-1,24,-1,-1,50,35,31,-1,-1,44,-1,-1,70,66,-1,-1,90,-1,-1});
        bt.levelOrder(head);
        System.out.println(bt.countNodes(head));
        System.out.println(bt.sumNodes(head));
        System.out.println(bt.heightTree(head, 1));
        System.out.println(bt.diameterTree(head));
    }
}
