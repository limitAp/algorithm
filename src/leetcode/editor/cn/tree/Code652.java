package leetcode.editor.cn.tree;

import leetcode.editor.cn.tree.data.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 创建日期 2020/07/30
 * 寻找重复的子树
 * @author pengzhuowei@fybdp.com
 * @since 1.0.0
 */
public class Code652 {

    public static void main(String[] args) {

    }

    Map<String, Integer> map = new HashMap<>();

    List<TreeNode> result = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        findResult(root);
        return result;
    }

    private String findResult(TreeNode root) {
        if (root == null) return "#";
        String leftStr = findResult(root.left);
        String rightStr = findResult(root.right);
        String sum = leftStr + "," + rightStr + "," + root.val;
        Integer integer = map.getOrDefault(sum, 0);
        if (integer == 1) {
            result.add(root);
        }
        map.put(sum, integer + 1);
        return sum;
    }
}
