package 链表;

import java.util.ArrayList;
import java.util.List;

public class 奇偶链表 {

    public ListNode oddEvenList(ListNode head) {
        List<ListNode> odd = new ArrayList<>();
        List<ListNode> even = new ArrayList<>();
        ListNode cur = head;
        for (int i = 1; cur!=null; i++) {
            if (i % 2 == 1) {
                odd.add(cur);
            }else {
                even.add(cur);
            }
            cur = cur.next;
        }
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        for (ListNode listNode : odd) {
            current.next = listNode;
            current = listNode;
        }
        for (ListNode listNode : even) {
            current.next = listNode;
            current = listNode;
        }
        current.next = null;
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(new 奇偶链表().oddEvenList(ListNode.create(1, 2, 3, 4, 5)));
    }
}
