package leetcode.editor.cn;
//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1027 👎 0

import java.util.LinkedList;
import java.util.List;

public class P46Permutations {
    public static void main(String[] args) {
        Solution solution = new P46Permutations().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private List<List<Integer>> result = new LinkedList<>();

        public List<List<Integer>> permute(int[] nums) {
            if (nums.length == 0) {
                return new LinkedList<>();
            }
            dfs(nums, new LinkedList<>());
            return result;
        }

        public void dfs(int[] nums, LinkedList<Integer> list) {
            if (list.size() == nums.length) {
                result.add(new LinkedList<>(list));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (list.contains(nums[i])) {
                    continue;
                }
                list.add(nums[i]);
                dfs(nums, list);
                list.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}