package leetcode.editor.cn.tree;

import leetcode.editor.cn.tree.data.TreeNode;

/**
 * 创建日期 2020/07/30
 *
 * @author pengzhuowei@fybdp.com
 * @since 1.0.0
 */
public class Code101 {


    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return judgeTree(root.left, root.right);
    }

    public boolean judgeTree(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val == right.val) {
            return judgeTree(left.left, right.right) && judgeTree(left.right, right.left);
        } else {
            return false;
        }
    }
}
