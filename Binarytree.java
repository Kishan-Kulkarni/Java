public class Binarytree {
    public static class Node{
        Node right;
        Node left;
        int val;

        public Node(int val){
            this.val=val;
            this.right=null;
            this.left = null;
        }
    }

    static int idx=-1;
    public static Node createTree(int[] values){
        idx++;
        if(values[idx]==-1){
            return null;
        }

        Node newNode= new Node(values[idx]);
        newNode.left=createTree(values);
        newNode.right = createTree(values);

        return newNode;
    }

    public static void printTree(Node node){
        if(node==null){
            return;
        }


        printTree(node.left);
        printTree(node.right);
        System.out.println(node.val);
    }

//    public static void levelPrint(Node root, int i){
//        if(curr == null){
//            return;
//        }
//
//        System.out.println(root.val);
//
//        if(i%2==0){
//            levelPrint(root, i+1);
//        }else{
//            levelPrint(root, i+1);
//        }
//
//    }

    public static int countNodes(Node root){
        if(root==null){
            return 0;
        }

        int count=0;

        count=countNodes(root.left)+countNodes(root.right);

        return count+1;

    }

    public static int sumNodes(Node root){
        if (root == null) {
            return 0;
        }

        return root.val + sumNodes(root.left) + sumNodes(root.right);
    }

    public static int height(Node root){
        if (root == null) {
            return 0;
        }

        int left=1+height(root.left);
        int right=1+height(root.right);

        return Math.max(left, right);

    }

    public static void main(String[] args) {
        int[] values={1,2,-1,-1,3,4,-1,-1,5,6,-1,-1,7,-1,-1};
        Node node= createTree(values);

//        System.out.println(node.val);

        printTree(node);
        System.out.println();

        System.out.println(countNodes(node));
        System.out.println();

        System.out.println(sumNodes(node));
        System.out.println(height(node));
    }
}
