package 二叉树;

/**
 * @author yangzhe14
 * @since 2024/7/28
 */
public class _297_二叉树序列化与反序列化 {
}


class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        traverse(root, stringBuilder);
        return stringBuilder.toString();
    }

    public void traverse(TreeNode root, StringBuilder buffer) {
        if (root == null) {
            buffer.append("#");
            return;
        }
        buffer.append(root.val);
        buffer.append("#");
        traverse(root.left, buffer);
        traverse(root.right, buffer);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] split = data.split("#");
        if (split == null || split.length == 0) {
            return null;
        }
        int length = split.length;

        // 这题之所以不会，是因为数据结构不清楚，这种要不断remove的结构是一个队列，或者自己搞一个链表，但是这块卡住了
        // 它通过链表结构往后传递处理进度
        return null;


    }
}