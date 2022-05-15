package tree;

public class 左叶子之和 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (isLeaf(root.left)) {
            return root.left.val + sumOfLeftLeaves(root.right);
        } else {
            return sumOfLeftLeaves(root.right) + sumOfLeftLeaves(root.left);
        }
    }

    private boolean isLeaf(TreeNode treeNode) {
        return treeNode!=null&&treeNode.left == null && treeNode.right == null;
    }
}
