package 树;

import 树.TreeNode;

public class 二叉搜索树中的搜索 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val == root.val) {
            return root;
        }
        else if (val > root.val) {
            return searchBST(root.right, val);
        }else {
            return searchBST(root.left, val);
        }
    }
}
