package 面试题;

import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangzhe14
 * @since 2024/9/21
 */
public class _0409_二叉搜索树序列 {

    public List<List<Integer>> BSTSequences(TreeNode root) {
        if (root == null) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }
        return recurse(root);
    }

    public List<List<Integer>> recurse(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> left = recurse(root.left);
        List<List<Integer>> right = recurse(root.right);
        List<List<Integer>> result = new ArrayList<>();
        if (left != null && right != null) {
            for (List<Integer> leftEle : left) {
                for (List<Integer> rightEle : right) {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(root.val);
                    cur.addAll(leftEle);
                    cur.addAll(rightEle);
                    result.add(cur);

                    List<Integer> cur2 = new ArrayList<>();
                    cur2.add(root.val);
                    cur2.addAll(rightEle);
                    cur2.addAll(leftEle);
                    result.add(cur2);
                }
            }
        }
        if (left != null && right == null) {
            for (List<Integer> leftEle : left) {
                List<Integer> cur = new ArrayList<>();
                cur.add(root.val);
                cur.addAll(leftEle);
                result.add(cur);
            }
        }

        if (left == null && right != null) {
            for (List<Integer> rightEle : right) {
                List<Integer> cur = new ArrayList<>();
                cur.add(root.val);
                cur.addAll(rightEle);
                result.add(cur);
            }
        }
        if (left == null && right == null) {
            ArrayList<Integer> cur = new ArrayList<>();
            cur.add(root.val);
            result.add(cur);
        }
        return result;
    }

}