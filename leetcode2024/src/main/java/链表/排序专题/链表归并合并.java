package 链表.排序专题;

import 顺序刷.ListNode;

/**
 * @author yangzhe14
 * @since 2024/10/7
 */
public class 链表归并合并 {

    public static void main(String[] args) {
        // 创建无序单链表
        ListNode head = new ListNode(5);
        head.next = new ListNode(1);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        ListNode node = sort(head);
        System.out.println(node);
    }

    public static ListNode sort(ListNode input) {
        if (input == null || input.next == null) {
            return input;
        }

        // 找到中间节点，断成两个链表
        ListNode middleNode = findMiddleNode(input);
        ListNode middleNext = middleNode.next;
        middleNode.next = null;

        ListNode left = sort(input);
        ListNode right = sort(middleNext);
        return merge(left, right);
    }

    public static ListNode merge(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        ListNode head = new ListNode(0);
        ListNode result = head;

        while (left != null && right != null) {
            if (left.val < right.val) {
                head.next = left;
                left = left.next;
            } else {
                head.next = right;
                right = right.next;
            }
            head = head.next;
        }
        if (left == null) {
            head.next = right;
        } else {
            head.next = left;
        }
        return result.next;
    }

    public static ListNode findMiddleNode(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        ListNode fast = node;
        ListNode slow = node;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}