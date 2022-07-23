package 树;

public class 对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        return match(root.left, root.right);
    }

    private boolean match(TreeNode left, TreeNode right) {
        if (left == right) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val
                && match(left.left, right.right)
                && match(left.right, right.left);
    }

}
