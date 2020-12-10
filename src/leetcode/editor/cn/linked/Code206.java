package leetcode.editor.cn.linked;

import java.util.Arrays;

/**
 * 创建日期 2020/07/30
 *
 * @author pengzhuowei@fybdp.com
 * @since 1.0.0
 */
public class Code206 {


    public static void main(String[] args) {

        int[] nums = new int[]{2, 7, 11, 15};
        int[] result = twoSum(nums, 9);
        System.out.println(Arrays.toString(result));

    }

    public static int[] twoSum(int[] nums, int target) {
        int sum;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum > target) {
                right = (left + right) / 2;
            } else {
                left = (left + right) / 2;
            }
        }
        return new int[]{-1, -1};
    }
}
