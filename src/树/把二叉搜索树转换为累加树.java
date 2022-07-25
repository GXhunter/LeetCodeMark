package 树;

import 树.TreeNode;

public class 把二叉搜索树转换为累加树 {
    int value = 0;

    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.right);
        value += root.val;
        root.val = value;
        traverse(root.left);
    }
}
