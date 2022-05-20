package tree;

/**
 * <a href="https://leetcode.cn/problems/delete-node-in-a-bst/">...</a>
 */
public class 删除二叉搜索树中的节点 {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode dummy = new TreeNode(0);
        dummy.right = root;
        TreeNode[] treeNodes = find(dummy, root, key);
        if (treeNodes == null) {
            return root;
        }
        TreeNode parent = treeNodes[0];
        TreeNode node = treeNodes[1];
        TreeNode newNode = null;
        if (node.left == null) {
            newNode = node.right;
        } else if (node.right == null) {
            newNode = node.left;
        }else {
            TreeNode left = findLeft(node.right);
            left.left = node.left;
            newNode = node.right;
        }
        if (parent.left!=null&&parent.left.val == node.val) {
            parent.left = newNode;
        }else {
            parent.right = newNode;
        }
        return dummy.right;
    }

    /**
     * 最左边
     * @param treeNode
     * @return
     */
    private TreeNode findLeft(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        TreeNode left = treeNode;
        while (left.left != null) {
            left = left.left;
        }
        return left;
    }

    private TreeNode[] find(TreeNode parent,TreeNode treeNode,int key) {
        if (treeNode == null) {
            return null;
        }
        if (treeNode.val == key) {
            return new TreeNode[]{parent,treeNode};
        }
        if (key <treeNode.val) {
            return find(treeNode,treeNode.left, key);
        }else {
            return find(treeNode,treeNode.right, key);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)), new TreeNode(6, null, new TreeNode(7)));
        System.out.println(new 删除二叉搜索树中的节点().deleteNode(treeNode, 5));
    }
}
