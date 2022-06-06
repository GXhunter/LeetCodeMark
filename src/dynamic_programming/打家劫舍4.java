package dynamic_programming;

import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/house-robber/">...</a>
 * 动态规划方式
 */
public class 打家劫舍4 {
    Map<TreeNode, Integer> cache = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (cache.containsKey(root)) {
            return cache.get(root);
        }
        int a = 0;
//        偷取当前房间
        a = root.val;
        if (root.left != null) {
            a += rob(root.left.left);
            a += rob(root.left.right);
        }
        if (root.right != null) {
            a += rob(root.right.left);
            a += rob(root.right.right);
        }
//        不偷取当前房间
        int b = 0;
        if (root.left!=null) {
            b += rob(root.left);
        }
        if (root.right != null) {
            b += rob(root.right);
        }
        cache.put(root, Math.max(a, b));
        return cache.get(root);
    }

    public static void main(String[] args) {
        System.out.println(new 打家劫舍4());
    }
}
