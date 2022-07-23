package 链表;

public class 反转链表2 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for(int i = 1; i < m; i++){
            pre = pre.next;
        }
        head = pre.next;
//        交换header 和nex
        for(int i = m; i < n; i++){
            ListNode nex = head.next;
            head.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] value = new int[]{1,2,3,4, 5};
        final ListNode header = new ListNode(value[0]);
        ListNode current = header;
        for (int j = 1; j < value.length; j++) {
            current.next = new ListNode(value[j]);
            current = current.next;
        }
        System.out.println(new 反转链表2().reverseBetween(header, 2, 4));
//        System.out.println(new 反转链表2().reverseBetween(header, 1, 2));
    }
}
