package 链表;

public class K个一组翻转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy.next;
        while (cur != null) {
            ListNode[] listNodes = reverseNode(cur, k);
            pre.next = listNodes[0];
            pre = listNodes[1];
            cur = listNodes[2];
        }
        return dummy.next;
    }

    /**
     * 局部往后翻转k个节点，并返回 首节点和下一轮开始节点
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode[] reverseNode(ListNode head, int k) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;

        int sum = 0;
        for (int i = 0; i < k && cur!=null; i++) {
            cur = cur.next;
            sum++;
        }
        if (sum != k) {
            return new ListNode[]{head,head,null};
        }
        cur = head;
        for (int i = 0; i < k && cur != null; i++) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return new ListNode[]{pre,head,next};
    }


    public static void main(String[] args) {
        System.out.println(new K个一组翻转链表().reverseKGroup(ListNode.create(1, 2, 3, 4, 5), 3).showInfo());
    }
}
