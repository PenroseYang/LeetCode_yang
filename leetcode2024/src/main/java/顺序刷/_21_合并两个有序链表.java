package 顺序刷;

/**
 * @author yangzhe14
 * @since 2024/8/19
 * <p>
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 * <p>
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 */
public class _21_合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode head = result;
        ListNode left = list1;
        ListNode right = list2;

        while (left != null || right != null) {
            if (left == null) {
                head.next = right;
                head = head.next;
                right = right.next;
            } else if (right == null) {
                head.next = left;
                head = head.next;
                left = left.next;
            } else {
                if (left.val <= right.val) {
                    head.next = left;
                    head = head.next;
                    left = left.next;
                } else {
                    head.next = right;
                    head = head.next;
                    right = right.next;
                }
            }
        }
        return result.next;
    }
}