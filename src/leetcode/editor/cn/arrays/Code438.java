package leetcode.editor.cn.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 创建日期 2020/07/30
 *
 * @author pengzhuowei@fybdp.com
 * @since 1.0.0
 */
public class Code438 {

    public static void main(String[] args) {
        String s = "baa";
        String p = "aa";
        List<Integer> index = findAnagrams(s, p);
        System.out.println(index.toString());
    }

    public static List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < p.toCharArray().length; i++) {
            need.put(p.charAt(i), need.getOrDefault(p.charAt(i), 0) + 1);
        }
        int left = 0, right = 0, valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.keySet().contains(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            while (right - left >= p.length()) {
                if (valid == need.keySet().size()) {
                    result.add(left);
                }
                char c1 = s.charAt(left);
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
        return result;
    }
}
