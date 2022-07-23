package 链表;

import java.util.ArrayList;
import java.util.List;

/**
 * todo
 * https://leetcode.cn/problems/reorder-list/
 */
public class 重排链表 {
    public void reorderList(ListNode head) {
        List<ListNode> listNodes = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            listNodes.add(cur);
            cur = cur.next;
        }
        ListNode middle = listNodes.get(listNodes.size() / 2);
        cur = head;
        for (int i = 0; i < listNodes.size() / 2; i++) {
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        ListNode node = ListNode.create(1, 2, 3, 4);
        new 重排链表().reorderList(node);
        System.out.println(node.showInfo());
    }
}
