package 剑指offer;

import 链表.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 排序链表 {

    public ListNode sortList(ListNode head) {
        Queue<ListNode> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        while (head != null) {
            q.add(head);
            head = head.next;
        }
        ListNode dummy = new ListNode();
        ListNode pre = dummy;
        while (!q.isEmpty()) {
            pre.next = q.poll();
            pre = pre.next;
        }
        pre.next = null;
        return dummy.next;
    }
}
