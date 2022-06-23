package offer;

import linked.ListNode;

public class 环形链表2 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (slow == null || fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (slow!=fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2, listNode);
        System.out.println(new 环形链表2().detectCycle(listNode));
    }

}
