package 树;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的前序遍历 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverse(root, res);
        return res;
    }

    private void traverse(TreeNode treeNode, List<Integer> res) {
        if (treeNode == null) {
            return;
        }
        res.add(treeNode.val);
        traverse(treeNode.left, res);
        traverse(treeNode.right, res);
    }
}
