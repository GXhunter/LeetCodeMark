package 剑指offer;

import 链表.ListNode;

public class 删除链表的节点 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur!=null) {
            if (cur.val == val) {
                pre.next = cur.next;
                break;
            }else {
                cur = cur.next;
                pre = pre.next;
            }

        }
        return dummy.next;
    }
}
