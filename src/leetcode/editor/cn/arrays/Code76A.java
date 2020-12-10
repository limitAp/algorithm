package leetcode.editor.cn.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 创建日期 2020/07/30
 *
 * @author pengzhuowei@fybdp.com
 * @since 1.0.0
 */
public class Code76A {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String s1 = minWindow(s, t);
        System.out.println(s1);
    }

    public static String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            Integer value = need.getOrDefault(t.charAt(i), 0);
            need.put(t.charAt(i), value + 1);
        }
        int left = 0;
        int right = 0;
        int start = 0, len = Integer.MAX_VALUE;
        int valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.keySet().contains(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char c1 = s.charAt(left);
                left++;
                if (need.keySet().contains(c1)) {
                    if (window.get(c1).equals(need.get(c1))) {
                        valid--;
                    }
                    Integer value = window.get(c1);
                    value--;
                    if (value == 0) {
                        window.remove(c1);
                    } else {
                        window.put(c1, value);
                    }
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
