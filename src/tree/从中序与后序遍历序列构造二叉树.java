package tree;

public class 从中序与后序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    /**
     * [start,end] 双闭区间
     */
    private TreeNode build(int[] inorder, int inStart, int inEnd,
                           int[] postorder, int postStart, int postEnd) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        //        找到分界点
        int index = inStart;
        for (; index <= inEnd; index++) {
            if (inorder[index] == root.val) {
                break;
            }
        }
        int leftSize = index - inStart;
//        与前中不同的是，这里需要-1，由于后序遍历，
        root.left = build(inorder, inStart, index - 1,
                postorder, postStart, postStart + leftSize - 1
        );
        root.right = build(inorder, index + 1, inEnd,
                postorder, postStart + leftSize, postEnd - 1
        );
        return root;

    }

}
