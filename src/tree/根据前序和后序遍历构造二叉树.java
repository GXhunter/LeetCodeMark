package tree;

public class 根据前序和后序遍历构造二叉树 {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] postorder, int postStart, int postEnd) {
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        } else if (preStart > preEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int leftRootVal = preorder[preStart + 1];
        //        找到分界点
        int index = postStart;
        for (; index <= postEnd; index++) {
            if (postorder[index] == leftRootVal) {
                break;
            }
        }
//        因为leftRoot也是左子树，所以需要+1
        int leftSize = index - postStart + 1;
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                postorder, postStart, index);
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                postorder, index + 1, postEnd - 1);
        return root;
    }
}
