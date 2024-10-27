package 顺序刷;

/**
 * @author yangzhe14
 * @since 2024/8/19
 */
public class _19_删除链表的倒数第N个结点 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode virtualHead = new ListNode();
        virtualHead.next = head;
        ListNode fast = virtualHead;
        ListNode slow = virtualHead;
        // 快指针先往后走几步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // 快慢一起
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return virtualHead.next;
    }
}