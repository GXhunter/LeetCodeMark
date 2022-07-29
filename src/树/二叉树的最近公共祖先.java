package 树;

public class 二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        先序位置
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
//        后序位置，左右节点都找到目标值，当前元素就是最近祖先
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
//            LCA是左子树根节点
            return left;
        }
        if (right != null) {
//            LCA是右子树根节点
            return right;
        }
        return null;
    }
}
