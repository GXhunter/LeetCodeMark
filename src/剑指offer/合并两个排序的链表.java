package 剑指offer;

import 链表.ListNode;

public class 合并两个排序的链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val< l2.val) {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            else {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(new 合并两个排序的链表().mergeTwoLists(
                new ListNode(1, new ListNode(2, new ListNode(4))),
                new ListNode(1, new ListNode(3, new ListNode(4)))
        ));
    }
}
