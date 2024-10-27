package 左神;

import 顺序刷.ListNode;

/**
 * @author yangzhe14
 * @since 2024/8/26
 *
 * todo 考察的就是边界，从哪里遍历到哪里
 */
public class _单链表部分反转从m到n的节点 {

    public static void main(String[] args) {
        ListNode root = new ListNode(1, new ListNode(2, new ListNode(3,
                new ListNode(4, new ListNode(5)))));
        reverseMToN(root, 2, 4);
        System.out.println();
    }

    public static ListNode reverseMToN(ListNode root, int m, int n) {
        if (root == null || root.next == null) {
            return root;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = root;
        ListNode mPreviousNode = dummy;
        for (int i = 0; i < m; i++) {
            mPreviousNode = mPreviousNode.next;
        }
        // 找到了m之前的那个元素
        ListNode left = mPreviousNode.next;
        ListNode right = left.next;

        ListNode tem = null;
        for (int i = m; i < n; i++) {
            ListNode next = right.next;
            tem = right.next;
            right.next = left;
            left = right;
            right = tem;
        }
        // 反转部分之外的一头一尾节点的处理
        mPreviousNode.next.next = right;
        mPreviousNode.next = left;
        return dummy.next;
    }
}