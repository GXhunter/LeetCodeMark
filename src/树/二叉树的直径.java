package 树;

import java.util.HashMap;
import java.util.Map;

public class 二叉树的直径 {
    Integer res = 0;
    Map<TreeNode, Integer> memo = new HashMap<>();
    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        res = Math.max(res,maxDepth(root.left)+maxDepth(root.right));

        traverse(root.left);
        traverse(root.right);

    }

    public int maxDepth(TreeNode root) {
        if (memo.containsKey(root)) {
            return memo.get(root);
        }
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int i = 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        memo.put(root, i);
        return memo.get(root);
    }
}
