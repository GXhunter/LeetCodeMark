package linked;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return val +"->" + (next == null ? "NULL" : next.toString());
    }

    public static ListNode create(int... nums) {
        int[] value = new int[]{1, 4, 3, 2, 5, 2};
        final ListNode header = new ListNode(value[0]);
        ListNode current = header;
        for (int j = 1; j < value.length; j++) {
            current.next = new ListNode(value[j]);
            current = current.next;
        }
        return header;
    }
}
