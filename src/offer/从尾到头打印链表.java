package offer;

import linked.ListNode;

import java.util.ArrayList;
import java.util.List;

public class 从尾到头打印链表 {

    public int[] reversePrint(ListNode head) {
        List<Integer> res = new ArrayList<>();
        while (head != null) {
            res.add(head.val);
            head = head.next;
        }
        int[] result = new int[res.size()];
        for (int i = res.size() - 1; i >= 0; i--) {
            result[res.size()-i-1] = res.get(i);
        }
        return result;
    }

}
