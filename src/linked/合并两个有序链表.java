package linked;

public class 合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode res = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val< list2.val) {
                res.next = list1;
                list1 = list1.next;
            }else {
                res.next = list2;
                list2 = list2.next;
            }
            res = res.next;
        }
        if (list1 != null) {
            res.next = list1;
        }
        if (list2 != null) {
            res.next = list2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(new 合并两个有序链表().mergeTwoLists(ListNode.create(1, 2, 4), ListNode.create(1, 3, 4)).showInfo());
    }
}
