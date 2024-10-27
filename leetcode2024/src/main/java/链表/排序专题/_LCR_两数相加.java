package 链表.排序专题;

import 顺序刷.ListNode;

/**
 * @author yangzhe14
 * @since 2024/10/8
 */
public class _LCR_两数相加 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode recurseL1 = recurse(l1);
        ListNode recurseL2 = recurse(l2);

        int numAdd = 0;
        ListNode result = new ListNode(0);
        ListNode pre = result;

        // 这个循环条件还是得记一下的
        while (recurseL1 != null || recurseL2 != null || numAdd > 0) {
            int num1 = recurseL1 != null ? recurseL1.val : 0;
            int num2 = recurseL2 != null ? recurseL2.val : 0;
            if (recurseL1 != null) {
                recurseL1 = recurseL1.next;
            }
            if (recurseL2 != null) {
                recurseL2 = recurseL2.next;
            }
            int all = num1 + num2 + numAdd;
            numAdd = all / 10;
            ListNode cur = new ListNode(all % 10);
            pre.next = cur;
            pre = cur;
        }
        return recurse(result.next);
    }

    public static ListNode recurse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head.next;
        // 1 2 3 4 5
        while (next != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }
        cur.next = pre;
        return cur;
    }
}