package offer;

import java.util.HashMap;
import java.util.Map;

public class 复杂链表的复制 {

    Map<Node,Node> cache = new HashMap<>();
    public Node copyRandomList(Node head) {
        Node headCopy = head;
        if (head == null) {
            return null;
        }
        Node dummy = new Node(0);
        Node pre = dummy;
        Node cur;
        while (head != null) {

            cur = new Node(head.val);
            cache.put(head, cur);
            pre.next = cur;

            pre = cur;
            head = head.next;
        }
        head = headCopy;
        cur = dummy.next;
        while (head != null) {
            cur.random = cache.get(head.random);

            cur = cur.next;
            head = head.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Node node = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        node.random = null;
        node.next = node2;


        node2.random = node;
        node2.next = node3;


        node3.random = node5;
        node3.next = node4;


        node4.random = node3;
        node4.next = node5;


        node5.random = node;
        node5.next = null;

        new 复杂链表的复制().copyRandomList(node);
        System.out.println(node);
    }
}
