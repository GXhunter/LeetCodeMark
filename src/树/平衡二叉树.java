package 树;

public class 平衡二叉树 {

    public boolean isBalanced(TreeNode root) {
        return root == null || postTraverse(root) != -1;
    }

    /**
     * 后续遍历，如果是平衡二叉树，就返回高度，否则返回-1
     */
    private int postTraverse(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int leftHeight = postTraverse(treeNode.left);
        int rightHeight = postTraverse(treeNode.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(3,
                        new TreeNode(4), null
                ), null)
                , new TreeNode(3, null, new TreeNode(3, null, new TreeNode(4))
        )
        );
        System.out.println(new 平衡二叉树().isBalanced(root));
    }

}
