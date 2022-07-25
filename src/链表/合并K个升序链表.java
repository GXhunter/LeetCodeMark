package 链表;

import 链表.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 合并K个升序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null||lists.length==0) {
            return null;
        }
        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode listNode : lists) {
            if (listNode != null) {
                queue.add(listNode);
            }
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            cur.next = poll;
            cur = poll;
            if (poll.next != null) {
                queue.add(poll.next);
            }
        }

        return dummy.next;
    }
}
