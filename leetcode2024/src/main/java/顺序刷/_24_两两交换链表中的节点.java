package 顺序刷;

/**
 * @author yangzhe14
 * @since 2024/8/19
 * <p>
 * 1234变成2143，两两一组来交换
 */
public class _24_两两交换链表中的节点 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        node = swapPairs(node);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    // 两两一交换
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode virtualHead = new ListNode();
        virtualHead.next = head;
        ListNode result = virtualHead;
        while (result != null) {
            // result后面凑不出两组了
            if (result.next == null || result.next.next == null) {
                return virtualHead.next;
            }
            // result是开头的
            ListNode next = result.next;
            ListNode nextNext = next.next;
            next.next = nextNext.next;
            nextNext.next = next;
            result.next = nextNext;
            result = next;
        }
        return virtualHead.next;
    }
}