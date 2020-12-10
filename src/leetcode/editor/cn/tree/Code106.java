package leetcode.editor.cn.tree;

import leetcode.editor.cn.tree.data.TreeNode;

/**
 * 创建日期 2020/07/30
 *
 * @author pengzhuowei@fybdp.com
 * @since 1.0.0
 */
public class Code106 {

    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return build(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    /**
     * 从中序与后序遍历序列构造二叉树
     *
     * @param inorder   中序遍历
     * @param inStart
     * @param inEnd
     * @param postorder 后序便利
     * @param posStart
     * @param posEnd
     * @return
     */
    private TreeNode build(int[] inorder, int inStart, int inEnd,
                           int[] postorder, int posStart, int posEnd) {

        if (inStart > inEnd) {
            return null;
        }
        int index = 0;
        int rootVale = postorder[posEnd];
        for (int i = inStart; i <= inEnd; i++) {
            if (rootVale == inorder[i]) {
                index = i;
                break;
            }
        }
        int size = index - inStart;
        TreeNode treeNode = new TreeNode(rootVale);
        treeNode.left = build(inorder, inStart, index - 1,
                postorder, posStart, posStart + size - 1);
        treeNode.right = build(inorder, index + 1, inEnd,
                postorder, posStart + size, posEnd - 1);
        return treeNode;
    }

}
