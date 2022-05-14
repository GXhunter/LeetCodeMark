package linked;

public class 奇偶链表 {

    public ListNode oddEvenList(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;
        ListNode left = dummy;
        for (int i = 1; cur!=null; i++) {
            if (i%2==1) {
                pre.next = cur.next;
                cur.next = left.next;
                left.next = cur;
                left = cur;
            }
            pre = cur.next;
            cur = cur.next.next;

        }
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(new 奇偶链表().oddEvenList(ListNode.create(1, 2, 3, 4, 5)));
    }
}
