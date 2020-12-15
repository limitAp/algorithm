package leetcode.editor.cn;
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2817 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P15ThreeSum {
    public static void main(String[] args) {
        Solution solution = new P15ThreeSum().new Solution();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        solution.threeSum(nums);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums.length == 0) {
                return new ArrayList<>();
            }
            int target = 0;
            Arrays.sort(nums);
            List<List<Integer>> res = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                List<List<Integer>> result = twoSum(nums, i + 1, target - nums[i]);
                for (List<Integer> list : result) {
                    list.add(nums[i]);
                    res.add(list);
                }
                while (i < (nums.length - 1) && nums[i + 1] == nums[i]) i++;
            }
            return res;
        }

        public List<List<Integer>> twoSum(int[] nums, int start, int target) {
            int left = start, right = nums.length - 1;
            List<List<Integer>> result = new LinkedList<>();
            while (left < right) {
                int sum = nums[left] + nums[right];
                int leftNum = nums[left];
                int rightNum = nums[right];
                if (sum < target) {
                    while (left < right && leftNum == nums[left]) left++;
                } else if (sum > target) {
                    while (left < right && rightNum == nums[right]) right--;
                } else {
                    LinkedList<Integer> list = new LinkedList<>();
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    while (left < right && leftNum == nums[left]) left++;
                    while (left < right && rightNum == nums[right]) right--;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}