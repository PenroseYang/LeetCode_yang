package 链表;

import 顺序刷.Node;

/**
 * @author yangzhe14
 * @since 2024/10/8
 * <p>
 * 好险好险，循环链表插入，这要是不刷一下这不疯了啊！
 * 循环链表插入，天哪这个题！做起来感觉要疯了似的！
 */
public class LCR_循环有序链表的插入 {

    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }
        Node insertPre = findInsertPre(head, insertVal);
        Node next = insertPre.next;
        Node insertNode = new Node(insertVal);
        insertPre.next = insertNode;
        insertNode.next = next;
        return head;
    }

    // 三种情况，直接插入了，前面一个节点小，后面一个节点大；插入的是最小节点，插入的是最大节点
    public Node findInsertPre(Node head, int insertVal) {
        Node cur = head;
        Node result = cur;

        // 这种情况比较麻烦了呀
        while (cur.next != head) {
            // 找到了当场返回
            if (cur.val <= insertVal && cur.next.val >= insertVal) {
                return cur;
            }
            if (cur.val > cur.next.val) {
                result = cur;
            }
            cur = cur.next;
        }
        if (cur.val <= insertVal && cur.next.val >= insertVal) {
            return cur;
        }
        if (cur.val > cur.next.val) {
            result = cur;
        }
        return result;
    }
}