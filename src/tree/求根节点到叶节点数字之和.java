package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/sum-root-to-leaf-numbers/
 */
public class 求根节点到叶节点数字之和 {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        for (String s : num(root)) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }

    /**
     * 节点代表的数字
     * @param node
     * @return
     */
    public List<String> num(TreeNode node) {
        List<String> res = new ArrayList<>();
        if (node == null) {
            return res;
        }
        if (node.left == null && node.right == null) {
            res.add(node.val + "");
        }
        for (String item : num(node.left)) {
            res.add(node.val+item);
        }
        for (String item : num(node.right)) {
            res.add(node.val+item);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new 求根节点到叶节点数字之和().sumNumbers(
                new TreeNode(1,new TreeNode(2),new TreeNode(3))
        ));
    }
}
