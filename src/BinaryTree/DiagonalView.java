package BinaryTree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class DiagonalView {
    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    public ArrayList<Integer> diagonal(TreeNode root)
    {
        ArrayList<Integer> diagonal = new ArrayList<Integer>();
        if(root == null){
            return diagonal;
        }
        while (root != null) {

            // Add current node to output
            diagonal.add(root.val);
            // If left child available, add it to queue
            if (root.left != null)
                queue.add(root.left);

            // if right child, transfer the node to right
            if (root.right != null)
                root = root.right;
            else {
                // If left child Queue is not empty, utilize
                // it to traverse further
                if (!queue.isEmpty()) {
                    root = queue.peek();
                    queue.remove();
                }
                else {
                    // All the right childs traversed and no
                    // left child left
                    root = null;
                }
            }
        }
        return diagonal;
    }
}
