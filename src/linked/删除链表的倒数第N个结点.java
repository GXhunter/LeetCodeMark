package linked;

/**
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 */
public class 删除链表的倒数第N个结点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode right = head;
        for (int i = 0; i < n; i++) {
            right = right.next;
        }
        while (right != null) {
            right = right.next;
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = cur.next;
        return dummy.next;

    }

    public static void main(String[] args) {
        System.out.println(new 删除链表的倒数第N个结点().removeNthFromEnd(ListNode.create(1, 2, 3, 4, 5), 2).showInfo());
    }
}
