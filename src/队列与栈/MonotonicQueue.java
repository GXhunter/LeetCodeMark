package 队列与栈;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/**
 * 单调队列
 */
public class MonotonicQueue {
    private final Deque<Integer> deque = new LinkedList<>();

    public Integer maxValue() {
        return deque.getFirst();
    }

    public void push(Integer value) {
        while (!deque.isEmpty() && deque.getLast() < value) {
            deque.removeLast();
        }
        deque.addLast(value);
    }

    // 队头元素如果是 n，删除它
    public void removeFirst(Integer value) {
        if (Objects.equals(deque.getFirst(), value)) {
            deque.removeFirst();
        }
    }
}
