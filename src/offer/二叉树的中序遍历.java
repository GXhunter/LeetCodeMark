package offer;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (root.left != null) {
            res.addAll(inorderTraversal(root.left));
        }
        res.add(root.val);
        if (root.right != null) {
            res.addAll(inorderTraversal(root.right));
        }
        return res;
    }
}
