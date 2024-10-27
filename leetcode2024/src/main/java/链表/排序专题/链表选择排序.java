package 链表.排序专题;

import 顺序刷.ListNode;

/**
 * @author yangzhe14
 * @since 2024/10/7
 */
public class 链表选择排序 {

    public static void main(String[] args) {
        // 创建无序单链表
        ListNode head = new ListNode(5);
        head.next = new ListNode(1);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        ListNode node = chooseSort(head);
        System.out.println(node);
    }

    public static ListNode chooseSort(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode head = new ListNode(0);
        head.next = node;

        ListNode resultPre = new ListNode(0);
        ListNode minCur = resultPre;
        while (head.next != null) {
            ListNode minPre = getMinPre(head);
            // 把minNode节点给删了
            ListNode minNode = minPre.next;
            minPre.next = minNode.next;
            // 把min节点顺在原来的排序链表后面
            minCur.next = minNode;
            minCur = minNode;
        }
        return resultPre.next;
    }

    public static ListNode getMinPre(ListNode node) {
        ListNode minPre = node;
        ListNode cur = node;
        while (cur.next != null) {
            if (minPre.next.val > cur.next.val) {
                minPre = cur;
            }
            cur = cur.next;
        }
        return minPre;
    }
}