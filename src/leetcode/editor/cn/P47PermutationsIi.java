package leetcode.editor.cn;
//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 回溯算法 
// 👍 538 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class P47PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new P47PermutationsIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private List<List<Integer>> result = new LinkedList<>();

        public List<List<Integer>> permuteUnique(int[] nums) {
            if (nums.length == 0) {
                return new LinkedList<>();
            }
            boolean[] use = new boolean[nums.length];
            Arrays.sort(nums);
            dfs(nums, new LinkedList<>(), use);
            return result;
        }

        public void dfs(int[] nums, LinkedList<Integer> list, boolean[] use) {
            if (nums.length == list.size()) {
                result.add(new LinkedList<>(list));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (list.contains(nums[i]) && (i > 0 && nums[i] == nums[i - 1] && use[i - 1])) {
                    continue;
                }
                if (!use[i]) {
                    use[i] = true;
                    list.add(nums[i]);
                    dfs(nums, list, use);
                    list.removeLast();
                    use[i] = false;
                }

            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}