package 链表;

import 顺序刷.ListNode;

/**
 * @author yangzhe14
 * @since 2024/9/16
 * <p>
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 200] 内
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 */
public class _86_分隔链表 {

    public static void main(String[] args) {
        ListNode test = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));
        ListNode partition = partition(test, 3);
        System.out.println(partition);
    }

    public static ListNode partition(ListNode head, int x) {
        // 如果只有一个节点以内，根本不用排序
        if (head == null || head.next == null) {
            return head;
        }

        ListNode small = new ListNode(0);
        ListNode smallCurrent = small;
        ListNode large = new ListNode(0);
        ListNode largeCurrent = large;

        while (head != null) {
            if (head.val < x) {
                smallCurrent.next = head;
                smallCurrent = smallCurrent.next;
            } else {
                largeCurrent.next = head;
                largeCurrent = largeCurrent.next;
            }
            head = head.next;
        }

        /**
         * todo 重点关注的问题，链表最后成环的问题
         * 链表如果要进行重排序，最容易出问题的就是最末尾的那个元素
         * 中间的元素要么排序没变，要么都已经遍历完了，那中间元素的next指针也都已经排好了
         * 就怕尾结点的元素，它的next指针还维持着原来的指针，只是把它上一个节点的next指针指过来了
         */
        largeCurrent.next = null;
        smallCurrent.next = large.next;
        return small.next;
    }
}