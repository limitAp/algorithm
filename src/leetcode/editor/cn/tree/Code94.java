package leetcode.editor.cn.tree;

import leetcode.editor.cn.tree.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建日期 2020/07/30
 *
 * @author pengzhuowei@fybdp.com
 * @since 1.0.0
 */
public class Code94 {

    private List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {

        traversal(root);
        return list;
    }

    private void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(root.left);
        list.add(root.val);
        traversal(root.right);
    }
}
