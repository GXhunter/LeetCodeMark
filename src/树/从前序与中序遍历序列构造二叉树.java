package 树;

public class 从前序与中序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    public TreeNode buildTree(
            int[] preorder, int preFrom, int preTo,
            int[] inorder, int inFrom, int inTo
    ) {
        if (preFrom >= preTo) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preFrom]);
//        找到分界点
        int index = inFrom;
        for (; index < inTo; index++) {
            if (inorder[index] == root.val) {
                break;
            }
        }
        int leftSize = index - inFrom;
        root.left = buildTree(preorder, preFrom + 1, preFrom + leftSize + 1
                , inorder, inFrom, index);
        root.right = buildTree(preorder, preFrom + leftSize + 1, preTo, inorder, index + 1, inTo);

        return root;
    }
}
