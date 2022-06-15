package offer;

import tree.TreeNode;

public class 对称的二叉树 {
    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left ==  right;
        }
        boolean res = left.val == right.val;
        res &= isSymmetric(left.left, right.right);
        res &= isSymmetric(left.right, right.left);
        return res;
    }
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }
}
