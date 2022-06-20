package offer;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 二叉搜索树的第k大节点 {
    public int kthLargest(TreeNode root, int k) {
        List<Integer> dsf = dsf(root);
        return dsf.get(dsf.size() - k);
    }

    List<Integer> dsf(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root.left != null) {
            list.addAll(dsf(root.left));
        }
        list.add(root.val);
        if (root.right != null) {
            list.addAll(dsf(root.right));
        }
        return list;
    }
}
