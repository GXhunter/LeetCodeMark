package 链表;

public class 两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        int temp = 0;
        for (ListNode pre = dummy, cur = null; l1 != null || l2 != null || temp != 0; pre.next = cur, pre = cur) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int sum = a + b + temp;
            cur = new ListNode(sum % 10);
            temp = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(new 两数相加().addTwoNumbers(ListNode.create(9, 9, 9, 9, 9, 9, 9),
                ListNode.create(9, 9, 9, 9)));
    }
}
