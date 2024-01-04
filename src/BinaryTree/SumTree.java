package BinaryTree;

public class SumTree {
    class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = null;
            right = null;
        }
    }


    public int toSumTree(Node root) {
        int returwn = 0;
        if(root == null) return 0;

        if(root.left == null && root.right == null){
            int val = root.data;
            root.data = 0;
            return val;
        }

        int left = toSumTree(root.left);
        int right = toSumTree(root.right);

        int temp = root.data;
        root.data = left + right;

        return temp + root.data;
    }
}
