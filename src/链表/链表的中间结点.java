package 链表;

import 链表.ListNode;

public class 链表的中间结点 {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null&&fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
