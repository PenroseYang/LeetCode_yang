package 顺序刷;

/**
 * @author yangzhe14
 * @since 2024/8/19
 */
public class Node {
    public int val;
    public Node next;
     public Node random;

    Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}