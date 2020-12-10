package leetcode.editor.cn.tree;

import leetcode.editor.cn.tree.data.TreeNode;

/**
 * 创建日期 2020/07/30
 *
 * @author pengzhuowei@fybdp.com
 * @since 1.0.0
 */
public class Code105 {

    /**
     * 从前序与中序遍历序列构造二叉树
     *
     * @param args
     */
    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }


    private TreeNode build(int[] preorder, int start1, int end1,
                           int[] inorder, int start2, int end2) {
        if (start1 > end1) {
            return null;
        }
        int index = 0;
        int rootVal =  preorder[start1];
        for (int i = start2; i <= end2; i++) {
            if (rootVal == inorder[i]) {
                index = i;
                break;
            }
        }
        int leftSize = index - start2;
        TreeNode treeNode = new TreeNode(rootVal);
        treeNode.left = build(preorder, start1 + 1, start1 + leftSize,
                inorder, start2, index - 1);

        treeNode.right = build(preorder, start1 + leftSize + 1, end1,
                inorder, index + 1, end2);
        return treeNode;
    }


}
