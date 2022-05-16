package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/path-sum-ii/comments/
 */
public class 路径总和2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (root.left == null && root.right == null) {
            if (targetSum == root.val) {
                List<Integer> list = new ArrayList<>();
                list.add(root.val);
                res.add(list);
            }
            return res;
        }
        for (List<Integer> link : pathSum(root.left, targetSum - root.val)) {
            link.add(0,root.val);
            res.add(link);
        }
        for (List<Integer> link : pathSum(root.right, targetSum - root.val)) {
            link.add(0,root.val);
            res.add(link);
        }
        return res;
    }
}
