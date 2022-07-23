package 剑指offer;

import 树.TreeNode;

public class 二叉搜索树的第k大节点 {
    int count = 0;
    int res;
    public int kthSmallest(TreeNode root, int k) {
        traverse(root,k);
        return res;
    }

    private void traverse(TreeNode root,int k) {
        if (root == null) {
            return;
        }
        traverse(root.left,k);
        count++;
        if (count==k){
            res = root.val;
            return;
        }
        traverse(root.right,k);
    }
}
