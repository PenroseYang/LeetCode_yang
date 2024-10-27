package 链表;

import 顺序刷.ListNode;

import java.util.PriorityQueue;

/**
 * @author yangzhe14
 * @since 2024/9/14
 * <p>
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 * <p>
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 * 提示：
 * <p>
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 */
public class _23_合并K个升序链表 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                continue;
            }
            priorityQueue.add(lists[i]);
        }

        ListNode head = new ListNode(0);
        ListNode resultPre = head;
        while (!priorityQueue.isEmpty()) {
            ListNode poll = priorityQueue.poll();
            head.next = poll;
            head = head.next;
            if (poll.next != null) {
                priorityQueue.add(poll.next);
            }
        }
        return resultPre.next;
    }
}