package 链表;

import 顺序刷.ListNode;

/**
 * @author yangzhe14
 * @since 2024/9/16
 * <p>
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 示例 2：
 * <p>
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 * 提示：
 * <p>
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 * 进阶： 你可以使用一趟扫描完成反转吗？
 */
public class _92_反转链表2 {

    public static void main(String[] args) {
        ListNode tem = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        reverseBetween(tem, 2, 4);
    }

    // 这题是一个部分反转
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right || head == null || head.next == null) {
            return head;
        }
        ListNode preHead = new ListNode(0);
        preHead.next = head;

        ListNode reversePre = null;
        ListNode reverseAfter = null;

        ListNode leftStartNdoe = null;
        ListNode rightEndNode = null;

        // 遍历循环的指针节点
        ListNode leftNode = preHead;
        ListNode rightNode = head;

        int leftIndex = 0;

        while ((leftIndex + 1) <= right) {
            if (leftIndex + 1 == left) {
                reversePre = leftNode;
            }
            if (leftIndex == left) {
                leftStartNdoe = leftNode;
            }
            if (leftIndex + 1 == right) {
                rightEndNode = rightNode;
                reverseAfter = rightEndNode.next;
            }
            // 当前的节点处于需要反转位置的节点中时
            if (leftIndex >= left && (leftIndex + 1) <= right) {
                ListNode tem = rightNode;
                rightNode = rightNode.next;
                tem.next = leftNode;
                leftNode = tem;
            } else {
                // 当前位置的节点不需要反转
                leftNode = rightNode;
                rightNode = rightNode.next;
            }
            leftIndex++;
        }

        reversePre.next = rightEndNode;
        leftStartNdoe.next = reverseAfter;
        return preHead.next;
    }
}