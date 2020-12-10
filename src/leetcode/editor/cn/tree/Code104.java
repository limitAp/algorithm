package leetcode.editor.cn.tree;

import leetcode.editor.cn.tree.data.TreeNode;

/**
 * 创建日期 2020/07/30
 *
 * @author pengzhuowei@fybdp.com
 * @since 1.0.0
 */
public class Code104 {

    public static void main(String[] args) {

    }

    int high = 0;

    public int maxDepth(TreeNode root) {
        depth(root);
        return high;
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        int maxTemp = Math.max(left, right);
        high = Math.max(maxTemp + 1, high);
        return Math.max(left, right) + 1;
    }
}
