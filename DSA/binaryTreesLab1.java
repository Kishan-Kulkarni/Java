package DSA;

public class binaryTreesLab1 {

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



    public void printTree(Node head){
        if(head==null || head.val==null){
            return;
        }

        System.out.print(head.val + " ");

        printTree(head.left);
        printTree(head.right);
    }

    public static void main(String[] args) {
        binaryTreesLab1 bt=new binaryTreesLab1();
        Node head=bt.insertArrayElements(new int[]{1,2,3,-1,-1,4,-1,-1,5,-1,-1});

        bt.printTree(head);
    }
}
