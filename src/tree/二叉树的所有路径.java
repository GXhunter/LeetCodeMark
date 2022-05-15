package tree;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的所有路径 {

    public List<String> binaryTreePaths(TreeNode root) {
        return echo(root);
    }

    private List<String> echo(TreeNode treeNode) {
        List<String> res = new ArrayList<>();
        if (treeNode == null) {
            return new ArrayList<>();
        }
        if (treeNode.left == null && treeNode.right==null) {
            res.add(String.valueOf(treeNode.val));
            return res;
        }

        for (String echo : echo(treeNode.left)) {
            res.add(treeNode.val + "->"+echo);
        }
        for (String echo : echo(treeNode.right)) {
            res.add(treeNode.val + "->"+echo);
        }
        return res;
    }
}
