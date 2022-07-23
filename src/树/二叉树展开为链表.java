package 树;

public class 二叉树展开为链表 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root);

    }

    /**
     * 以node为首节点的二叉树拉平
     *
     * @param node
     */
    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        traverse(node.left);
        traverse(node.right);
        TreeNode right = node.right;
        node.right = node.left;
        node.left = null;
        TreeNode pre = node;
        while (pre.right != null) {
            pre = pre.right;
        }
        pre.right = right;
    }

}
