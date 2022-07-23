package 树;

public class 二叉搜索树的范围和 {


    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.val > high) {
            res += rangeSumBST(root.left, low, high);
        } else if (root.val < low) {
            res += rangeSumBST(root.right, low, high);
        }else {
            res += rangeSumBST(root.left, low, high);
            res += rangeSumBST(root.right, low, high);
            res += root.val;
        }
        return res;
    }


}
