package 队列与栈;

import java.util.Stack;

public class 有效的括号 {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                case '[':
                case '{':
                    stack.push(s.charAt(i));
                    break;
                case ')':
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (stack.pop()!='(') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (stack.pop()!='[') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (stack.pop()!='{') {
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new 有效的括号().isValid("){"));
    }
}
