package 树;
// todo bug
public class 平衡二叉树 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) <= 1;
    }

    private int height(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        return Math.max(height(treeNode.left), height(treeNode.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3,
                                new TreeNode(4), null
                        ), null)
                , new TreeNode(3, null, new TreeNode(3, null, new TreeNode(4))
        )
        );
        System.out.println(new 平衡二叉树().isBalanced(root));
    }

}
