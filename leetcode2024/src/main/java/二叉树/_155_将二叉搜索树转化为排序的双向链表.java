package 二叉树;

import java.util.Stack;

/**
 * @author yangzhe14
 * @since 2024/9/21
 * <p>
 * 将一个 二叉搜索树 就地转化为一个 已排序的双向循环链表 。
 * <p>
 * 对于双向循环列表，你可以将左右孩子指针作为双向循环链表的前驱和后继指针，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 * <p>
 * 特别地，我们希望可以 就地 完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中最小元素的指针。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [4,2,5,1,3]
 * <p>
 * <p>
 * 输出：[1,2,3,4,5]
 * <p>
 * 解释：下图显示了转化后的二叉搜索树，实线表示后继关系，虚线表示前驱关系。
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [2,1,3]
 * 输出：[1,2,3]
 * 示例 3：
 * <p>
 * 输入：root = []
 * 输出：[]
 * 解释：输入是空树，所以输出也是空链表。
 * 示例 4：
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 * 提示：
 * <p>
 * -1000 <= Node.val <= 1000
 * Node.left.val < Node.val < Node.right.val
 * Node.val 的所有值都是独一无二的
 * 0 <= Number of Nodes <= 2000
 */
public class _155_将二叉搜索树转化为排序的双向链表 {

    public static void main(String[] args) {
        Node start = new Node(4, new Node(3, new Node(1, null, null), new Node(2, null, null)), new Node(5, null, null));
        Node node = treeToDoublyList(start);
        System.out.println(node);
    }

    public static Node treeToDoublyList(Node root) {
        Node head = root;
        Node pre = null;
        Node start = root;
        while (start.left != null) {
            start = start.left;
        }
        Stack<Node> stack = new Stack<>();

        while (head != null || !stack.isEmpty()) {
            while (head != null) {
                stack.push(head);
                head = head.left;
            }
            head = stack.pop();

            // 出循环之后，head变成了null
            if (pre != null) {
                pre.right = head;
            }
            head.left = pre;
            pre = head;
            head = head.right;
        }

        start.right = pre;
        pre.right = start;
        Node dummy = new Node(0);
        dummy.right = start;
        return dummy;
    }
}