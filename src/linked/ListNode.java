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
        return val+"";
    }

    public String showInfo() {
        return val + "->" + (next == null ? "NULL" : next.showInfo());
    }

    public static ListNode create(int... nums) {
        final ListNode header = new ListNode(nums[0]);
        ListNode current = header;
        for (int j = 1; j < nums.length; j++) {
            current.next = new ListNode(nums[j]);
            current = current.next;
        }
        return header;
    }
}
