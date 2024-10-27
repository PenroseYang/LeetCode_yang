package 链表;

import 顺序刷.ListNode;

/**
 * @author yangzhe14
 * @since 2024/10/8
 * <p>
 * 奇偶链表这个题还挺有意思的，链表由于改变了首尾指针，根本不能正常遍历
 * 考的还是链表删除之后重排序
 */
public class _328_奇偶链表 {

    public static void main(String[] args) {
        ListNode input = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))));
        ListNode node = oddEvenList(input);
        System.out.println(node);
    }

    // 12345 -> 13524
    public static ListNode oddEvenList(ListNode head) {
        // 两个节点以内没必要排序了
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        // 抽取奇数节点出来
        ListNode evenList = getEvenList(head);
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = evenList;
        return head;
    }

    // 1 2 3 4 5
    public static ListNode getEvenList(ListNode head) {
        ListNode virtual = new ListNode(0);
        ListNode result = virtual;

        ListNode cur = head;
        while (cur != null && cur.next != null) {
            // 把这个偶数节点摘出来
            ListNode even = cur.next;
            cur.next = even.next;
            cur = cur.next;

            even.next = null;
            virtual.next = even;
            virtual = even;
        }
        return result.next;
    }
}