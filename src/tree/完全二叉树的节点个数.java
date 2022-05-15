package tree;

public class 完全二叉树的节点个数 {
    public int countNodes(TreeNode root) {
        int count = 0;
        if (root == null) {
            return 0;
        }
        count++;
        count += countNodes(root.left);
        count += countNodes(root.right);
        return count;
    }
}
