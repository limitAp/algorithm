package leetcode.editor.cn.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 创建日期 2020/07/30
 *
 * @author pengzhuowei@fybdp.com
 * @since 1.0.0
 */
public class Code03 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, res = 0;
        Map<Character, Integer> window = new HashMap<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            right++;
            while (window.get(c) > 1) {
                char c1 = s.charAt(left);
                left++;

                Integer integer = window.get(c1);
                integer--;
                if (integer <= 0) {
                    window.remove(c1);
                } else {
                    window.put(c1, integer);
                }
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
