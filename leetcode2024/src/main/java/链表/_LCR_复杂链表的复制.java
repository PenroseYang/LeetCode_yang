package 链表;

import 顺序刷.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangzhe14
 * @since 2024/10/8
 */
public class _LCR_复杂链表的复制 {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Map<Node, Node> hashMap = createHashMap(head);
        return copyRandomList(head, hashMap);
    }

    private Node copyRandomList(Node head, Map<Node, Node> hashMap) {
        Node cur = head;
        while (cur != null) {
            Node copyCur = hashMap.get(cur);
            copyCur.next = hashMap.get(cur.next);
            copyCur.random = hashMap.get(cur.random);
            cur = cur.next;
        }
        return hashMap.get(head);
    }

    public Map<Node, Node> createHashMap(Node head) {
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        return map;
    }
}