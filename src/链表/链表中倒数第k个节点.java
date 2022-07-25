package 链表;

import 链表.ListNode;

public class 链表中倒数第k个节点 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode end = head;
        for (int i = 0; i < k; i++) {
            end = end.next;
        }
        while (end != null) {
            head = head.next;
            end = end.next;
        }
        return head;
    }

}
