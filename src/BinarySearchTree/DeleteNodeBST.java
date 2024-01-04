package BinarySearchTree;

import BinaryTree.TreeNode;

public class DeleteNodeBST {


    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        if(root.val < key) root.right = deleteNode(root.right, key);
        else if(root.val > key) root.left = deleteNode(root.left, key);
        else{
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            else{
                TreeNode lmax = root.right, par = null;

            }
        }
        return root;
    }
}
