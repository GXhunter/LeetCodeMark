package 链表;

public class 反转链表 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode listNode = reverseList(next);
        next.next = head;
        head.next = null;
        return listNode;
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
