package linked;

public class 两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur!=null&&cur.next != null) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = cur;
            pre.next = next;
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(new 两两交换链表中的节点().swapPairs(ListNode.create(1, 2, 3, 4)).showInfo());
    }
}
