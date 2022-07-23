package 链表;

public class 旋转链表 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null||k==0) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode right = dummy;
        for (int i = 0; i < k; i++) {
            right = right.next;
            if (right == null) {
                right = head;
            }
        }

        boolean needResolve = false;
        while (right.next != null) {
            right = right.next;
            cur = cur.next;
            pre = pre.next;
            needResolve = true;
        }
        if (needResolve) {
            pre.next = null;
            right.next = head;
        }

        return cur;

    }

    public static void main(String[] args) {
        System.out.println(new 旋转链表().rotateRight(ListNode.create(1,2), 2).showInfo());
    }
}
