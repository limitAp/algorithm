package leetcode.editor.cn.tree;

import leetcode.editor.cn.tree.data.TreeNode;

/**
 * 创建日期 2020/07/30
 *
 * @author pengzhuowei@fybdp.com
 * @since 1.0.0
 */
public class Code98 {

    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        return isBST(root, null, null);
    }

    public boolean isBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) return true;
        if (min != null && min.val >= root.val) return false;
        if (max != null && root.val >= max.val) return false;
        return isBST(root.left, min, root) && isBST(root.right, root, max);
    }
}
