package leetcode.editor.cn.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 创建日期 2020/07/30
 *
 * @author pengzhuowei@fybdp.com
 * @since 1.0.0
 */
public class Code567 {

    public static void main(String[] args) {

        String s1 = "ccccbbbbaaaa";
        String s2 = "abc";
        System.out.println(checkInclusion(s2, s1));

    }

    public static boolean checkInclusion(String s2, String s1) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < s2.toCharArray().length; i++) {
            need.put(s2.charAt(i), need.getOrDefault(s2.charAt(i), 0) + 1);
        }
        int left = 0, right = 0, valid = 0;
        while (right < s1.length()) {
            char c = s1.charAt(right);
            right++;
            //cbba  abc
            if (need.keySet().contains(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                //TODO
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            while (right - left >= s2.length()) {
                if (valid == need.keySet().size()) {
                    return true;
                }
                char c1 = s1.charAt(left);
                left++;
                if (need.keySet().contains(c1)) {
                    if (window.get(c1).equals(need.get(c1))) {
                        valid--;
                    }
                    Integer integer = window.get(c1);
                    integer--;
                    if (integer <= 0) {
                        window.remove(c1);
                    } else {
                        window.put(c1, integer);
                    }
                }
            }
        }
        return false;
    }
}
