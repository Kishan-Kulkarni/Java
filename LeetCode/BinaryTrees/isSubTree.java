package LeetCode.BinaryTrees;

public class isSubTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if( root == null){
            return false;
        }
        if(root.val == subRoot.val){
            if(isIdentical(root, subRoot)){
                return true;
            }
        }
        return  isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
    public boolean isIdentical(TreeNode root, TreeNode subRoot){
        if( root == null && subRoot == null){
            return true;
        }
        else if(root == null || subRoot == null  || root.val != subRoot.val){
            return false;
        }
        if(!isIdentical(root.left,subRoot.left)){
            return false;
        }
        return isIdentical(root.right, subRoot.right);
    }

    public static void main(String[] args) {

    }
}
