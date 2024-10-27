package 顺序刷;

/**
 * @author yangzhe14
 * @since 2024/8/19
 * <p>
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class _25_K个一组翻转链表 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        ListNode virtualHead = new ListNode();
        ListNode result = virtualHead;
        virtualHead.next = head;

        ListNode[] tem = new ListNode[k];
        while (virtualHead != null) {
            // 取了一下K个
            for (int i = 0; i < k; i++) {
                if (head == null) {
                    return result.next;
                } else {
                    // head标识一下遍历到哪里了
                    tem[i] = head;
                    head = head.next;
                }
            }

            virtualHead.next = tem[k-1];
            virtualHead = virtualHead.next;
            for (int i = k - 2; i >= 0; i--) {
                virtualHead.next = tem[i];
                virtualHead = virtualHead.next;
            }
            virtualHead.next = head;
        }
        return virtualHead.next;
    }
}