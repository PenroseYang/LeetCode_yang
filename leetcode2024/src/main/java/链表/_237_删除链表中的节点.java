package 链表;

import 顺序刷.ListNode;

/**
 * @author yangzhe14
 * @since 2024/10/8
 */
public class _237_删除链表中的节点 {

    public static void main(String[] args) {
        ListNode input = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))));
        deleteNode(input);
        System.out.println(input);
    }

    public static void deleteNode(ListNode node) {
        ListNode cur = node;
        ListNode next = node.next;

        while (next != null && next.next != null) {
            cur.val = next.val;
            cur = next;
            next = next.next;
        }
        cur.val = next.val;
        cur.next = null;
    }
}