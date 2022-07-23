package 树;

public class 最大二叉树 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return constructMaximumBinaryTreeRange(nums, 0, nums.length);
    }

    public TreeNode constructMaximumBinaryTreeRange(int[] nums, int from, int to) {
        if (to <= from) {
            return null;
        }
        int maxIndex = from;
        for (int i = from; i < to; i++) {
            if (nums[maxIndex] < nums[i]) {
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = constructMaximumBinaryTreeRange(nums, from, maxIndex);
        root.right = constructMaximumBinaryTreeRange(nums, maxIndex + 1, to);
        return root;
    }

}
