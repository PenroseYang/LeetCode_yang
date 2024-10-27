package 链表;

import 顺序刷.ListNode;

/**
 * @author yangzhe14
 * @since 2024/10/8
 */
public class _143_重排链表 {

    public static void main(String[] args) {
        ListNode input = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))));
        reorderList(input);
        System.out.println(input);
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode mediumNode = findMediumNode(head);
        ListNode mediumNext = mediumNode.next;
        // 断开中间节点
        mediumNode.next = null;
        ListNode mediumReverse = reverse(mediumNext);

        ListNode left = head;
        ListNode right = mediumReverse;
        ListNode cur = new ListNode(0);
        while (left != null && right != null) {
            cur.next = left;
            left = left.next;
            cur = cur.next;
            cur.next = right;
            cur = cur.next;
            right = right.next;
        }
        if (left != null) {
            cur.next = left;
        } else {
            cur.next = right;
        }
        return;
    }

    // 链表反转
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode virtual = new ListNode(0);
        ListNode pre = null;
        ListNode cur = head;
        // pre  cur  next
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static ListNode findMediumNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}