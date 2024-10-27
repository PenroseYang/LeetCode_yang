package 链表;

import 顺序刷.ListNode;

/**
 * @author yangzhe14
 * @since 2024/10/8
 * <p>
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你不需要 保留 每个分区中各节点的初始相对位置。
 * <p>
 * 示例 1：
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * <p>
 * 示例 2：
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 * <p>
 * 提示：
 * 链表中节点的数目在范围 [0, 200] 内
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 */
public class _面试题0204_分割链表 {

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode smallVirtual = new ListNode(0);
        ListNode smallCur = smallVirtual;
        ListNode headVirtual = new ListNode(0);
        headVirtual.next = head;
        ListNode cur = headVirtual;
        while (cur.next != null) {
            if (cur.next.val < x) {
                // 删除这个节点
                ListNode next = cur.next;
                cur.next = cur.next.next;

                // 把节点摘下来，放在small的列表里
                smallCur.next = next;
                next.next = null;
                smallCur = next;
            } else {
                cur = cur.next;
            }
        }

        if (smallCur != smallVirtual) {
            smallCur.next = headVirtual.next;
            return smallVirtual.next;
        } else {
            return head;
        }
    }
}