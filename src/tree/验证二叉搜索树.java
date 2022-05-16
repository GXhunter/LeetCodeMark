package tree;

/**
 * <a href="https://leetcode.cn/problems/validate-binary-search-tree/">...</a>
 */
public class 验证二叉搜索树 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    private boolean check(TreeNode root, Long max, Long min) {
        if (root == null) {
            return true;
        }
        boolean res = true;
        if (root.left != null) {
            res = root.val > root.left.val;
            res &= check(root.left, (long) root.val,min );
        }

        if (root.right != null) {
            res &= root.val < root.right.val;
            res &= check(root.right,max , (long) root.val);
        }
        return res && root.val < max && root.val > min;

    }

    public static void main(String[] args) {
//        System.out.println(new 验证二叉搜索树().isValidBST(new TreeNode(2, new TreeNode(1), new TreeNode(3))));
        System.out.println(new 验证二叉搜索树().isValidBST(new TreeNode(2147483647)));
    }
}
