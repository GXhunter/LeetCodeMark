package 队列与栈;

import java.util.Stack;

public class 用两个栈实现队列 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public 用两个栈实现队列() {

    }

    /**
     * 队尾插入元素
     * @param value
     */
    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (isEmpty()) {
            return -1;
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public boolean isEmpty() {
        return stack2.isEmpty() && stack1.isEmpty();
    }


}
