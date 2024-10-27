package 链表;

import 顺序刷.ListNode;

/**
 * @author yangzhe14
 * @since 2024/9/14
 * <p>
 * 给定单个链表的头 head ，使用 插入排序 对链表进行排序，并返回 排序后链表的头 。
 * <p>
 * 插入排序 算法的步骤:
 * <p>
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 * 下面是插入排序算法的一个图形示例。部分排序的列表(黑色)最初只包含列表中的第一个元素。每次迭代时，从输入数据中删除一个元素(红色)，并就地插入已排序的列表中。
 * <p>
 * 对链表进行插入排序。
 * <p>
 * 示例 1：
 * 输入: head = [4,2,1,3]
 * 输出: [1,2,3,4]
 * <p>
 * 示例 2：
 * 输入: head = [-1,5,3,4,0]
 * 输出: [-1,0,3,4,5]
 */
public class _147_链表排序 {

    public static void main(String[] args) {
        ListNode input = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))));
        ListNode node = insertionSortList(input);
        System.out.println(node);
    }

    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(Integer.MIN_VALUE);
        pre.next = head;
        ListNode headStart = pre;

        // 当前的head.next前面一定是升序有序排列的
        while (pre.next != null) {
            // 如果后面的这个节点是乱序的
            if (pre.next.val < pre.val) {
                // 先把pre.next节点摘了
                ListNode problemNode = pre.next;
                pre.next = problemNode.next;

                // 再找一个合适的位置把问题节点插入进去
                ListNode startNode = headStart;
                while (startNode.next.val < problemNode.val) {
                    startNode = startNode.next;
                }
                problemNode.next = startNode.next;
                startNode.next = problemNode;
            } else {
                // 正常就往后接着遍历
                pre = pre.next;
            }
        }
        return headStart.next;
    }
}