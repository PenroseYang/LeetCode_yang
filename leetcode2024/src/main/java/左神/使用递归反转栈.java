package 左神;

import java.util.Stack;

/**
 * @author yangzhe14
 * @since 2024/8/26
 * <p>
 * todo 这里就是考察队列和栈的，先进先出或者先进后出的特性
 */
public class 使用递归反转栈 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        reverse(stack);
        System.out.println(stack);
    }

    // 把123变成321
    public static void reverse(Stack<Integer> stack) {
        if (stack.size() == 0) {
            return;
        }
        Integer oldTop = stack.pop();
        reverse(stack);
        insertIntoBottom(stack, oldTop);
    }

    private static void insertIntoBottom(Stack<Integer> stack, Integer oldTop) {
        if (stack.isEmpty()) {
            stack.push(oldTop);
            return;
        } else {
            Integer pop = stack.pop();
            insertIntoBottom(stack, oldTop);
            stack.push(pop);
        }
    }
}