package offer;

import java.util.ArrayList;
import java.util.List;

public class 二叉搜索树与双向链表 {
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        List<Node> iter = iter(root);
        Node pre = null;
        for (Node node : iter) {
            if (pre != null) {
                pre.right = node;
            }
            node.left = pre;
            pre = node;
        }
        return iter.get(0);
    }

    private List<Node> iter(Node node) {
        List<Node> res = new ArrayList<>();
        if (node.left != null) {
            res.addAll(iter(node.left));
        }
        res.add(node);
        if (node.right != null) {
            res.addAll(iter(node.right));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new 二叉搜索树与双向链表().treeToDoublyList(new Node(4, new Node(2, new Node(1), new Node(3)), new Node(5))));
    }

}
