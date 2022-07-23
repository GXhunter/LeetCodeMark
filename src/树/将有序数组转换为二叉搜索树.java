package 树;

/**
 * <a href="https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/">...</a>
 */
public class 将有序数组转换为二叉搜索树 {

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = new TreeNode(nums[nums.length/2]);
        return null;
    }

    private TreeNode findPosition(TreeNode root,int num) {
        if (root.left == null && root.right == null) {
            return root;
        }
        if (num < root.val) {
            return findPosition(root.left, num);
        }else {
            return findPosition(root.right, num);
        }
    }
}
