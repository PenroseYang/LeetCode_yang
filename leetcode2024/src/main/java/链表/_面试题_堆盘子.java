package 链表;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yangzhe14
 * @since 2024/10/8
 */
public class _面试题_堆盘子 {


}

class StackOfPlates {
    public List<Stack<Integer>> stackList = null;
    public int cap = 0;

    public StackOfPlates(int cap) {
        stackList = new ArrayList<>();
        this.cap = cap;
    }

    public void push(int val) {
        if (stackList.size() == 0) {
            Stack<Integer> stack = new Stack<>();
            stack.push(val);
            stackList.add(stack);
        } else {
            Stack<Integer> stack = stackList.get(stackList.size() - 1);
            if (stack.size() == cap) {
                Stack<Integer> newStack = new Stack<>();
                newStack.push(val);
                stackList.add(newStack);
            } else {
                stack.push(val);
            }
        }
    }

    public int pop() {
        if (stackList.size() == 0) {
            return -1;
        }
        Stack<Integer> stack = stackList.get(stackList.size() - 1);
        Integer result = stack.pop();
        if (stack.size() == 0) {
            stackList.remove(stackList.size() - 1);
        }
        return result;
    }

    public int popAt(int index) {
        if (index < 0 || index >= stackList.size()) {
            return -1;
        }
        Stack<Integer> stack = stackList.get(index);
        Integer pop = stack.pop();
        if (stack.size() == 0) {
            stackList.remove(index);
        }
        return pop;
    }
}