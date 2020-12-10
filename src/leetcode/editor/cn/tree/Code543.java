package leetcode.editor.cn.tree;

import leetcode.editor.cn.tree.data.TreeNode;

/**
 * 创建日期 2020/07/30
 *
 * @author pengzhuowei@fybdp.com
 * @since 1.0.0
 */
public class Code543 {

    public static void main(String[] args) {

    }


    public int diameterOfBinaryTree(TreeNode root) {
        maxLength(root);
        return maxVal - 1;
    }

    int maxVal = 1;

    /**
     * 二叉树直径
     *
     * @param root
     * @return
     */
    private int maxLength(TreeNode root) {
        if (root == null) return 0;
        int left = maxLength(root.left);
        int right = maxLength(root.right);

        maxVal = Math.max(maxVal, left + right + 1);
        return Math.max(left, right) + 1;
    }
}
