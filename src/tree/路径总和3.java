package tree;

/**
 * 较为复杂的递归
 * <a href="https://leetcode.cn/problems/path-sum-iii/">原题</a>
 */
public class 路径总和3 {
    public int pathSum(TreeNode root, int targetSum) {
        int sum = 0;
        if (root == null) {
            return 0;
        }
        sum += pathSum(root.left, targetSum);
        sum += pathSum(root.right, targetSum);
//        包含此节点
        sum += fromNode(root, targetSum);
        return sum;
    }

    /**
     * 从此节点开始计算，符合条件的个数
     *
     * @param node
     * @return
     */
    public int fromNode(TreeNode node, int targetSum) {
        int count = 0;
        if (node == null) {
            return count;
        }
        if (node.val == targetSum) {
            count++;
        }
        count += fromNode(node.left, targetSum - node.val);
        count += fromNode(node.right, targetSum - node.val);
        return count;
    }
}
