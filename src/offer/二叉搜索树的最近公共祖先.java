package offer;

import tree.TreeNode;

public class 二叉搜索树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        int express = (root.val - p.val) * (root.val - q.val);
        if (express < 0) {
            return root;
        } else if (express==0) {
            return root;
        }else {
            return root.val > p.val ? lowestCommonAncestor(root.left, p, q) : lowestCommonAncestor(root.right, p, q);
        }
    }
}
