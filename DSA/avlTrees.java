package DSA;

public class avlTrees {
    Node root;
    static class Node {
        Integer key;
        int height;
        Node left, right;

        Node(int d) {
            key = d;
            height = 1;
        }
    }

    int height(Node N) {
        if (N == null)
            return 0;

        return N.height;
    }


    int max(int a, int b) {
        return Math.max(a, b);
    }


    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }


    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;


        y.left = x;
        x.right = T2;

        //  Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }


    int getBalance(Node N) {
        if (N == null)
            return 0;

        return height(N.left) - height(N.right);
    }

    Node insert(Node node, int key) {

        if (node == null)
            return (new Node(key));

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node;


        node.height = 1 + max(height(node.left),
                height(node.right));


        int balance = getBalance(node);



        if (balance > 1 && key < node.left.key)
            return rightRotate(node);


        if (balance < -1 && key > node.right.key)
            return leftRotate(node);


        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }


        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }


        return node;
    }

    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }

    }

    Node minValueNode(Node node)
    {
        Node current = node;


        while (current.left != null)
            current = current.left;

        return current;
    }

    Node deleteNode(Node root, int key)
    {

        if (root == null)
            return root;


        if (key < root.key)
            root.left = deleteNode(root.left, key);


        else if (key > root.key)
            root.right = deleteNode(root.right, key);


        else
        {


            if ((root.left == null) || (root.right == null))
            {
                Node temp = null;
                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;


                if (temp == null)
                {
                    temp = root;
                    root = null;
                }
                else
                    root = temp;
            }
            else
            {


                Node temp = minValueNode(root.right);


                root.key = temp.key;


                root.right = deleteNode(root.right, temp.key);
            }
        }


        if (root == null)
            return root;


        root.height = max(height(root.left), height(root.right)) + 1;


        int balance = getBalance(root);


        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);


        if (balance > 1 && getBalance(root.left) < 0)
        {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }


        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);


        if (balance < -1 && getBalance(root.right) > 0)
        {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    boolean search(Node head, int key){
        if(head!= null && head.key!=null && head.key==key){
            return true;
        }

        assert head != null;
        if(head.left == null && head.right == null){
            return false;
        }

        assert head.key != null;
        if(head.key>key){
            return search(head.left, key);
        }

        return search(head.right,key);
    }

    public static void main(String[] args) {
    avlTrees tree=new avlTrees();

        tree.root = tree.insert(tree.root, 9);
        tree.root = tree.insert(tree.root, 5);
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 0);
        tree.root = tree.insert(tree.root, 6);
        tree.root = tree.insert(tree.root, 11);
        tree.root = tree.insert(tree.root, -1);
        tree.root = tree.insert(tree.root, 1);
        tree.root = tree.insert(tree.root, 2);

        System.out.println("Pre order of the tree is:");
        tree.preOrder(tree.root);
        System.out.println();
        System.out.println("Deleting an element from the tree");
        tree.deleteNode(tree.root,0);
        System.out.println("Pre order of the new tree is:");
        tree.preOrder(tree.root);
        System.out.println();
        System.out.println("Searching for an element in the tree");
        System.out.println(tree.search(tree.root,2));
    }
}
