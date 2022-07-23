package 剑指offer;

import 树.TreeNode;

public class 二叉搜索树中第K小的元素 {
    public int kthSmallest(TreeNode root, int k) {
        return dsf(root, 0).val;
    }

    private TreeNode dsf(TreeNode treeNode,int k) {
        if (k == 1) {
            return treeNode;
        }
        if (treeNode.left != null) {
            dsf(treeNode.left, k);
        }
        k++;
        if (treeNode.right != null) {
            dsf(treeNode.right, k);
        }
        return null;
    }
}
