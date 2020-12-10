package leetcode.editor.cn.tree;

import leetcode.editor.cn.tree.data.TreeNode;

/**
 * 创建日期 2020/07/30
 *
 * @author pengzhuowei@fybdp.com
 * @since 1.0.0
 */
public class Code701 {

    public static void main(String[] args) {

    }

    /**
     * 二叉搜索树中的插入操作
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val == val) return null;
        if (root.val < val) root.right = insertIntoBST(root.right, val);
        if (root.val > val) root.left = insertIntoBST(root.left, val);
        return root;
    }
}
