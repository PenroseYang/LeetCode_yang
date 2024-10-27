package 链表;

import 顺序刷.ListNode;

/**
 * @author yangzhe14
 * @since 2024/9/14
 * <p>
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * <p>
 * 示例 2：
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 */
public class _61_旋转链表 {

    public ListNode rotateRight(ListNode head, int k) {
        ListNode firstNode = head;
        // 算一下链表长度
        int length = 0;
        while (firstNode != null) {
            firstNode = firstNode.next;
            length++;
        }

        // 实际转了一圈的扔掉
        k = k % length;
        if (k == 0) {
            return head;
        }
        // 找一下实际发生旋转的节点，那就是倒数第k个节点
        ListNode quickNode = head;
        ListNode slowNode = head;
        for (int i = 0; i < k; i++) {
            quickNode = quickNode.next;
        }
        while (quickNode.next != null) {
            quickNode = quickNode.next;
            slowNode = slowNode.next;
        }

        ListNode result = slowNode.next;
        slowNode.next = null;
        quickNode.next = head;
        return result;
    }
}