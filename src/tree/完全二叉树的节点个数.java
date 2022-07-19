package tree;

public class 完全二叉树的节点个数 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height = fullTreeHeight(root);
        if (height != 0) {
            return (int) Math.pow(2, height) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    /**
     * @param treeNode
     * @return 不能满二叉树返回0，否则返回高度
     */
    private int fullTreeHeight(TreeNode treeNode) {
        TreeNode left = treeNode.left, right = treeNode.right;
        int height = 0;
        while (left != null && right != null) {
            height++;
            left = left.left;
            right = right.right;
        }
        return left == right ? height + 1 : 0;
    }
}
