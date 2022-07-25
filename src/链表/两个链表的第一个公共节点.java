package 链表;

import java.util.HashSet;
import java.util.Set;

public class 两个链表的第一个公共节点 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        Set<ListNode> alist = new HashSet<>();
        ListNode cur;
        for (cur = headA; cur != null; cur = cur.next) {
            alist.add(cur);
        }
        for (cur = headB; cur != null; cur = cur.next) {
            if (alist.contains(cur)) {
                return cur;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new 两个链表的第一个公共节点().getIntersectionNode(
                new ListNode(8),
                new ListNode(4, new ListNode(1, new ListNode(8, new ListNode(5))))
        ));
    }
}
