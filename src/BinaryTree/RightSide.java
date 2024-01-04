package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RightSide {
    static List<Integer> all = new ArrayList<Integer>();
    public static List<Integer> rightSideView(TreeNode root) {
        rightElement(root);
        return all;
    }

    public static void rightElement(TreeNode root){
        LinkedList<TreeNode> que = new LinkedList<TreeNode>();
        if(root == null)
            return;
       que.addLast(root);
        while(que.size() != 0){
            all.add(que.removeFirst().val);
            while(que.size()-1 >0){
                if(root.right!= null) que.addLast(root.right);
                if(root.left!= null) que.addLast(root.left);
            }

        }
    }
    public static void main(String args[])
    {
        TreeNode tree = new TreeNode();
        tree.val = 1;
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        rightSideView(tree);
        System.out.println("right side view list  "+all);
    }
}
