package 树;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class 根据前序和后序遍历构造二叉树 {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
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

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.parse("2022-07-13 13:55:59.662", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        System.out.println(Duration.between(now.withNano(0).withSecond(0), now).toMinutes());
    }
}
