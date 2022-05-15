package tree;

public class 路径总和 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return targetSum==0;
        }
        if (root.right == null && root.left == null) {
            return root.val == targetSum;
        }
        return hasPathSum(root.right, targetSum - root.val) ||
                hasPathSum(root.left, targetSum - root.val);
    }


}
