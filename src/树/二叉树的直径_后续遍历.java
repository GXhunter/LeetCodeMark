package 树;

public class 二叉树的直径_后续遍历 {
    Integer res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return res;
    }


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        res = Math.max(left + right, res);
        return 1 + Math.max(left, right);
    }
}
