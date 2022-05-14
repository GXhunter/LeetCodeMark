package linked;

public class 回文链表 {
    public boolean isPalindrome(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }
        StringBuilder reverse = new StringBuilder(sb).reverse();
        return sb.toString().equals(reverse.toString());
    }

}
