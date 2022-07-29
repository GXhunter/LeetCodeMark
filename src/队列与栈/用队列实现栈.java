package 队列与栈;

import java.util.LinkedList;
import java.util.Queue;

public class 用队列实现栈  {
    private Queue<Integer> inputQueue;
    /**
     * 输出队列
     */
    private Queue<Integer> outputQueue;
    public 用队列实现栈() {
        inputQueue = new LinkedList<>();
        outputQueue = new LinkedList<>();
    }

    public void push(int x) {
        inputQueue.add(x);
        while (!outputQueue.isEmpty()) {
            inputQueue.offer(outputQueue.poll());
        }
        Queue<Integer> temp = inputQueue;
        inputQueue = outputQueue;
        outputQueue = temp;
    }

    public int pop() {
        return outputQueue.remove();
    }

    public int top() {
        return outputQueue.element();
    }

    public boolean empty() {
        return inputQueue.isEmpty() && outputQueue.isEmpty();
    }
}
