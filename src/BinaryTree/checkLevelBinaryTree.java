package BinaryTree;

public class checkLevelBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        if(Math.abs(lh - rh) > 1)
            return false;
        else
            return true;
    }

    public int height(TreeNode root) {
        if(root == null){
            return 0;
        }else{
            return Math.max(height(root.right),height(root.left))+1;
        }
    }

}
