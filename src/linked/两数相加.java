package linked;
//todo 待定大数相加
public class 两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder a = new StringBuilder();

        for (ListNode cur = l1; cur != null; cur = cur.next) {
            a.append(cur.val);
        }
        Long integer = Long.valueOf(a.reverse().toString());

        StringBuilder b = new StringBuilder();

        for (ListNode cur = l2; cur != null; cur = cur.next) {
            b.append(cur.val);
        }
        Long integer2 = Long.valueOf(b.reverse().toString());
        Long sum = integer+integer2;
        String s = new StringBuilder(sum + "").reverse().toString();
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        for (int i = 0; i < s.length(); i++) {
            cur.next = new ListNode(s.charAt(i)-'0');
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(new 两数相加().addTwoNumbers(ListNode.create(1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1),
                ListNode.create(5,6,4)));
    }
}
