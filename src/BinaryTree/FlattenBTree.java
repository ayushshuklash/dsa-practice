package BinaryTree;
/*
    1
   / \
  2   5
 / \   \
3   4   6
-----------
pre = 5
cur = 4

    1
   /
  2
 / \
3   4
     \
      5
       \
        6
-----------
pre = 4
cur = 3

    1
   /
  2
 /
3
 \
  4
   \
    5
     \
      6
-----------
cur = 2
pre = 3

    1
   /
  2
   \
    3
     \
      4
       \
        5
         \
          6
-----------
cur = 1
pre = 2

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
 */
public class FlattenBTree {
    TreeNode prev=null;
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
