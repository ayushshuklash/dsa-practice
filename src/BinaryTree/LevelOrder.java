package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    List<List<Integer>> all = new ArrayList<>();
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        int level = 1;
//        while (reclevelorder(root, level)) {
//            level++;
//        }
//    }
//   boolean reclevelorder(TreeNode root, Integer level){
//       if (root == null) {
//           return false;
//       }
//       List<Integer> levels = new ArrayList<Integer>();
//       if (level == 1)
//       {
//          levels.add(root.val);
//           return true;
//       }
//       boolean left = reclevelorder(root.left, level - 1);
//       boolean right = reclevelorder(root.right, level - 1);
//
//       return left || right;
//    }
    TreeNode root;
    void levelOrder(){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode tempNode = queue.poll();
            List<Integer> tempList = new ArrayList<Integer>();
            if(tempNode.left != null){
                queue.add(tempNode.left);
                tempList.add(tempNode.left.val);
            }
            if(tempNode.right!= null){
                queue.add(tempNode.right);
                tempList.add(tempNode.right.val);
            }
            all.add(tempList);
        }
    }
}
