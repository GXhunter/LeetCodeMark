package 链表;

public class 移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(new 移除链表元素().removeElements(ListNode.create(7,7,7,7), 7));
    }
}
