package 链表;

import 顺序刷.ListNode;

/**
 * @author yangzhe14
 * @since 2024/9/14
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * 提示：
 * <p>
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 * <p>
 * <p>
 * 妈的链表还挺难的啊！！！
 * <p>
 * <p>
 * todo 链表技巧，千万不能再链表里面使用break，就得用while循环条件来卡
 */
public class _2_两数相加 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode node = addTwoNumbers(l1, l2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = new ListNode(0);
        ListNode head2 = new ListNode(0);
        head1.next = l1;
        head2.next = l2;

        /**
         * 链表的问题，当前节点一定是非null的，如果当前节点是null节点，还得处理一下去找前一个节点
         * head节点存在的意义是为了不特殊处理第一个节点或者是null链表
         * 编程小技巧之一，是head节点，之二是  while(head.next!=null)
         *
         *
         * 因为都是对head.next去做操作的，所以实际上next节点才是当前节点
         * 所以每次判断next不是空的时候，都一定要定义这个next节点
         */
        while (head1.next != null && head2.next != null) {
            ListNode head1Next = head1.next;
            ListNode head2Next = head2.next;
            int sum = head1Next.val + head2Next.val;
            if (sum < 10) {
                head1Next.val = sum;
            } else {
                // 加和大于10产生进位
                head1Next.val = sum % 10;
                if (head1Next.next == null) {
                    if (head2Next.next != null) {
                        head2Next.next.val += sum / 10;
                    } else {
                        head1Next.next = new ListNode(1);
                    }
                } else {
                    head1Next.next.val += sum / 10;
                }
            }
            head1 = head1Next;
            head2 = head2Next;
        }
        if (head1.next == null) {
            head1.next = head2.next;
        }
        while (head1 != null) {
            if (head1.val >= 10) {
                if (head1.next == null) {
                    head1.next = new ListNode(1);
                    head1.val = head1.val % 10;
                } else {
                    head1.next.val += head1.val / 10;
                    head1.val = head1.val % 10;
                }
            }
            head1 = head1.next;
        }
        return l1;
    }
}