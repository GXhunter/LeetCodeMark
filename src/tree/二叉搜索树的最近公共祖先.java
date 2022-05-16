package tree;

public class 二叉搜索树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ((root.val - p.val) * (root.val - q.val) <= 0) {
            return root;
        }
        return p.val < root.val ? lowestCommonAncestor(root.left, p, q) : lowestCommonAncestor(root.right, p, q);

    }

}
