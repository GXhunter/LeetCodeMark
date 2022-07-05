package tree;

import linked.ListNode;

public class 二叉树中的列表 {
    public boolean isSubPath(ListNode head, TreeNode root) {
        return traverse(root, head);
    }

    private boolean traverse2(TreeNode root, ListNode head) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (root.val == head.val) {
            if (traverse(root, head)) {
                return true;
            }
        }
        return traverse2(root.left, head) || traverse2(root.right, head);
    }

    private boolean traverse(TreeNode root, ListNode head) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        //            搜索
        return root.val == head.val && (traverse(root.left, head.next) || traverse(root.right, head.next));
    }


}
