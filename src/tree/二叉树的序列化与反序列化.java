package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class 二叉树的序列化与反序列化 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serialize2(Arrays.asList(root)).substring(1);
    }

    public StringBuilder serialize2(java.util.Collection<TreeNode> root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        for (TreeNode treeNode : root) {
            sb.append(",");
            if (treeNode == null) {
                sb.append("#");
            } else {
                sb.append(treeNode.val);
                queue.add(treeNode.left);
                queue.add(treeNode.right);
            }
        }
        if (!queue.isEmpty()) {
            sb.append(serialize2(queue));
        }
        return sb;
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedBlockingDeque<>(Arrays.asList(data.split(",")));
        String poll = queue.poll();
        TreeNode root = null;
        if (!"#".equals(poll)) {
            root = new TreeNode(Integer.parseInt(poll));

        }

        return root;
    }


    public static void main(String[] args) {
        TreeNode deserialize = new 二叉树的序列化与反序列化().deserialize("1,2,3,#,#,4,5,#,#,#,#");
        System.out.println(deserialize);
    }
}
