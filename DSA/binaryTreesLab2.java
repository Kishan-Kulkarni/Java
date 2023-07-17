package DSA;

import java.util.Objects;

public class binaryTreesLab2 {
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
            return new Node();

        Node newNode=new Node(arr[index]);
        newNode.left=insertArrayElements(arr);
        newNode.right = insertArrayElements(arr);

        return newNode;
    }

    public boolean search(Node head, int val){
        if(head!= null && head.val!=null && head.val==val){
            return true;
        }

        assert head != null;
        if(head.left == null && head.right == null){
            return false;
        }

        assert head.val != null;
        if(head.val>val){
            return search(head.left, val);
        }

        return search(head.right,val);
    }

    public void deleteNode(Node head, int val){
        Node toBeDeleted=findDeletionNode(head, val);

        assert toBeDeleted != null;
        if(toBeDeleted.right.val==null && toBeDeleted.left.val == null){
            toBeDeleted.val=null;
            return;
        }

        if(toBeDeleted.right.val == null){
            toBeDeleted.val=toBeDeleted.left.val;
            toBeDeleted.left.val=null;
            return;
        }

        if(toBeDeleted.left.val == null){
            toBeDeleted.val=toBeDeleted.right.val;
            toBeDeleted.right.val=null;
            return;
        }

        Node inOrderSuccessor=findInOrderSuccessor(head, toBeDeleted.val);
        int temp=head.val;
        head.val=inOrderSuccessor.val;
        deleteNode(inOrderSuccessor, inOrderSuccessor.val);
        head.val = temp;
    }

    private Node findInOrderSuccessor(Node head, int val) {
        if(head==null || head.val==null){
            return null;
        }

        if(head.val == val){
            return findInOrderSuccessor(head.right, val);
        }else if(head.val<val){
            return findInOrderSuccessor(head.right, val);
        }else{
            if(head.left.val==null && head.right.val == null){
                return head;
            }else if(head.left.val==null){
                return head;
            }else if(head.right.val==null){
                return findInOrderSuccessor(head.left, val);
            }else{
                return findInOrderSuccessor(head.left, val);
            }
        }
    }

    private Node findDeepestNode(Node head , Node prev) {
        if(head!=null){
            if(head.right!=null){
                return findDeepestNode(head.right, head);
            }else if (head.left != null){
                return findDeepestNode(head.left, head);
            }
        }

        return prev;
    }

    private Node findDeletionNode(Node head, int val) {
        if(head!= null && head.val!=null && head.val==val){
            return head;
        }

        assert head != null;
        if(head.left == null && head.right == null){
            return null;
        }

        assert head.val != null;
        if(head.val>val){
            return findDeletionNode(head.left, val);
        }

        return findDeletionNode(head.right,val);
    }

    public void printTree(Node head){
        if(head==null || head.val==null){
            return;
        }

        System.out.print(head.val + " ");

        printTree(head.left);
        printTree(head.right);
    }

    public void preOrder(Node head){
        if(head==null || head.val==null){
            return;
        }

        System.out.print(head.val + " ");

        preOrder(head.left);
        preOrder(head.right);
    }

    public void inOrder(Node head){
        if(head==null || head.val==null){
            return;
        }

        inOrder(head.left);
        System.out.print(head.val + " ");
        inOrder(head.right);
    }

    public void postOrder(Node head){
        if(head==null || head.val==null){
            return;
        }

        postOrder(head.left);
        postOrder(head.right);
        System.out.print(head.val + " ");
    }

    public static void main(String[] args) {
        binaryTreesLab2 bt=new binaryTreesLab2();
        binaryTreesLab2.Node head=bt.insertArrayElements(new int[]{45,23,14,-1,-1,36,28,-1,-1,-1,67,58,-1,-1,-1});
        System.out.println(bt.search(head, 5));

        System.out.println("Displaying the tree");
        bt.printTree(head);
        System.out.println();
        System.out.println("Displaying the tree in pre-order");
        bt.preOrder(head);
        bt.deleteNode(head, 36);
        System.out.println();
        System.out.println("Displaying the tree in pre-order after deletion");
        bt.preOrder(head);
        System.out.println();
        System.out.println("Displaying the tree in in-order");
        bt.inOrder(head);
        System.out.println();
        System.out.println("Displaying the tree in post-order");
        bt.postOrder(head);
    }
}
