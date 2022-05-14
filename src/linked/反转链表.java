package linked;

public class 反转链表 {

    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre==null?new ListNode():pre;

    }

    public static void main(String[] args) {
        int[] value = new int[]{1,2,3,4,5};
        final ListNode header = new ListNode(value[0]);
        ListNode current = header;
        for (int j = 1; j < value.length; j++) {
            current.next = new ListNode(value[j]);
            current = current.next;
        }
        System.out.println(new 反转链表().reverseList(header));
    }
}
