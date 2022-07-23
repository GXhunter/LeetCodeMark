package 链表;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
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
