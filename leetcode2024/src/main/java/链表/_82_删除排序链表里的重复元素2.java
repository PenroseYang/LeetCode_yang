package 链表;

import 顺序刷.ListNode;

/**
 * @author yangzhe14
 * @since 2024/9/14
 * <p>
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 * 提示：
 * <p>
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 * Related Topics
 */
public class _82_删除排序链表里的重复元素2 {

    public static void main(String[] args) {

    }

    public static ListNode deleteDuplicates(ListNode head) {
        // 如果只有一个的话，就不用处理了
        if (head == null || head.next == null) {
            return head;
        }
        ListNode virtualHead = new ListNode(0);
        virtualHead.next = head;

        ListNode pre = virtualHead;
        ListNode left = head;
        ListNode right = head.next;

        while (right != null) {
            if (left.val == right.val) {
                // right往右接着走，走到前后不相等的位置上
                right = right.next;
                pre.next = right;
            } else {
                // 如果这时候左右不相等了，开始判断
                if(left.next == right){
                    // 左节点合格了
                    pre = left;
                    left = right;
                    right = right.next;
                }else{
                    pre.next = right;
                    left = right;
                    right = right.next;
                }
            }
        }
        return virtualHead.next;
    }
}