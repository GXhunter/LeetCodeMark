package linked;

public class 删除链表中的节点 {
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }

    public static void main(String[] args) {
        new 删除链表中的节点().deleteNode(ListNode.create(4,5,1,9));
    }
}
