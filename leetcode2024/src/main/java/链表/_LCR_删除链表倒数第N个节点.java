package 链表;

import 顺序刷.ListNode;

/**
 * @author yangzhe14
 * @since 2024/10/8
 */
public class _LCR_删除链表倒数第N个节点 {

    // 12345
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode virtual = new ListNode(0);
        virtual.next = head;
        ListNode fast = virtual;
        ListNode slow = virtual;

        // fast节点走n步，这个还真得想想，这就是高德一面的时候，说的差了一个节点的问题
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return virtual.next;
    }
}