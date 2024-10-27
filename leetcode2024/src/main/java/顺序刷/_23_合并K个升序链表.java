package 顺序刷;

/**
 * @author yangzhe14
 * @since 2024/8/19
 * <p>
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * <p>
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
 * <p>
 * <p>
 * todo 优先级队列还是不会用啊！每次取一个最小这种事情就是用优先级队列，搞这么复杂！
 */
public class _23_合并K个升序链表 {
    public static void main(String[] args) {
        // 初始化链表
        ListNode list1 = new ListNode(1, new ListNode(4, new ListNode(7)));
        ListNode list2 = new ListNode(1, new ListNode(4, new ListNode(4)));
        ListNode list3 = new ListNode(2, new ListNode(6));
        ListNode[] lists = new ListNode[]{list1, list2, list3};

        ListNode result = mergeKLists(lists);
        // 打印合并后的链表
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode head = new ListNode();
        ListNode result = head;
        // 当前有几组处理完毕的
        int process = 0;
        int length = lists.length;
        while (process < length) {
            // 选哪个组的
            int select = 0;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    continue;
                }
                if (head.next == null) {
                    head.next = lists[i];
                    select = i;
                } else if (head.next.val > lists[i].val) {
                    head.next = lists[i];
                    select = i;
                }
            }
            // 选中了某个之后，这一个往后推一个位置
            lists[select] = lists[select].next;
            head = head.next;
            head.next = null;
            if (lists[select] == null) {
                process++;
            }
        }
        return result.next;
    }
}