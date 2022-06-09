package offer;

import linked.ListNode;

public class 反转链表 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = cur.next;
        while (next != null) {
            ListNode temp = next.next;
            next.next = cur;
            cur.next = pre;

            pre = cur;
            cur = next;
            next = temp;
        }
        return cur;
    }

    public static void main(String[] args) {
        new 反转链表().reverseList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
    }
}
