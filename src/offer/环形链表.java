package offer;

import linked.ListNode;

public class 环形链表 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        int i = 1;
        while (slow != null &&fast!=null&& fast.next != null ) {
            i++;
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                System.out.println(i);
                return true;
            }
        }
        System.out.println(i);
        return false;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(3);
        listNode.next = new ListNode(2, new ListNode(0, new ListNode(-4, listNode)));
        System.out.println(new 环形链表().hasCycle(listNode));
    }
}
