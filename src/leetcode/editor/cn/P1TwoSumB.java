package leetcode.editor.cn;
//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表 
// 👍 9824 👎 0

import java.util.Arrays;

public class P1TwoSumB {
    public static void main(String[] args) {
        //Solution solution = new P1TwoSumB().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            if (nums.length == 0) {
                return new int[0];
            }
            int left = 0, right = nums.length - 1;
            Arrays.sort(nums);
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    return new int[]{left, right};
                }
            }
            return new int[0];
        }

        public int[] twoSumB(int[] nums, int target) {
            if (nums.length == 0) {
                return new int[0];
            }
            int left = 0, right = nums.length - 1;
            Arrays.sort(nums);
            while (left < right) {
                int sum = nums[left] + nums[right];
                int leftNum = nums[left];
                int rightNum = nums[right];
                if (sum > target) {
                    while (left < right && nums[right] == rightNum) right--;
                } else if (sum < target) {
                    while (left < right && nums[left] == leftNum) left++;
                } else {
                    //TODO添加 left right
                    while (left < right && nums[left] == leftNum) left++;
                    while (left < right && nums[right] == rightNum) right--;
                }
            }
            return new int[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}