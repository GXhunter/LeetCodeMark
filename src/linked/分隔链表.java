package linked;

class 分隔链表 {

    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;
        ListNode left = dummy;
        while (cur != null) {
            if (cur.val < x) {
                pre.next = cur.next;
                cur.next = left.next;
                left.next = cur;
                left = cur;
            }
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] value = new int[]{1, 4, 3, 2, 5, 2};
        final ListNode header = new ListNode(value[0]);
        ListNode current = header;
        for (int j = 1; j < value.length; j++) {
            current.next = new ListNode(value[j]);
            current = current.next;
        }
        System.out.println(new 分隔链表().partition(header, 3));
    }
}
