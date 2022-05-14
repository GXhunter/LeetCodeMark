package linked;

public class 删除排序链表中的重复元素2 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            boolean isOver = false;
            while (next != null && cur.val == next.val) {
                next = next.next;
                isOver = true;
            }

            if (isOver) {
                pre.next = next;
                cur = next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(new 删除排序链表中的重复元素2().deleteDuplicates(ListNode.create(1, 1, 1, 2, 3)).showInfo());
    }
}
