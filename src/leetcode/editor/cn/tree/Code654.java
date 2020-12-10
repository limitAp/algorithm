package leetcode.editor.cn.tree;

import leetcode.editor.cn.tree.data.TreeNode;

/**
 * 创建日期 2020/07/30
 *
 * @author pengzhuowei@fybdp.com
 * @since 1.0.0
 */
public class Code654 {

    public static void main(String[] args) {

    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int index = -1, maxNum = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            if (nums[i] >= maxNum) {
                maxNum = nums[i];
                index = i;
            }

        }
        TreeNode root = new TreeNode(maxNum);
        root.left = buildTree(nums, start, index - 1);
        root.right = buildTree(nums, index + 1, end);
        return root;
    }
}
