package leetcode.editor.cn.tree;

import leetcode.editor.cn.tree.data.TreeNode;

/**
 * 创建日期 2020/07/30
 *
 * @author pengzhuowei@fybdp.com
 * @since 1.0.0
 */
public class Code230 {

    /**
     * 二叉搜索树中第K小的元素
     *
     * @param args
     */
    public static void main(String[] args) {

    }

    int count = 0;

    int result = -1;

    public int kthSmallest(TreeNode root, int k) {

        smallData(root, k);
        return result;
    }

    private void smallData(TreeNode root, int k) {
        if (root == null) return;
        kthSmallest(root.left, k);
        count++;
        if (count == k) {
            result = root.val;
        }
        kthSmallest(root.right, k);
    }


}
