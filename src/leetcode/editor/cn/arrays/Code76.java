package leetcode.editor.cn.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 创建日期 2020/07/30
 *
 * @author pengzhuowei@fybdp.com
 * @since 1.0.0
 */
public class Code76 {

    public static void main(String[] args) {
        String s = "aa";
        String t = "aa";
        String s1 = minWindow(s, t);
        System.out.println(s1);
    }

    public static String minWindow(String s, String t) {
        if (s == null || t == null) {
            return "";
        }
        if (t.length() > s.length()) {
            return "";
        }
        StringBuilder interval = new StringBuilder();
        int left, right;
        int len = Integer.MAX_VALUE;
        int start = 0;
        left = right = 0;
        Map<Character, AtomicInteger> map = new HashMap<>();
        Map<Character, AtomicInteger> map1 = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            AtomicInteger a = map1.computeIfAbsent(t.charAt(i), m -> new AtomicInteger());
            a.incrementAndGet();
        }

        while (right < s.length()) {
            char c = s.charAt(right);
            if (t.contains(c + "")) {
                AtomicInteger atomicInteger = map.computeIfAbsent(c, x -> new AtomicInteger());
                atomicInteger.incrementAndGet();
            }
            interval.append(c);
            right++;
            while (map.keySet().size() == map1.keySet().size()) {
                if (right - left < len) {
                    start = left;
                    len = right - start;

                }
                char temp = interval.charAt(left);
                if (t.contains(temp + "")) {
                    int v = map.get(temp).decrementAndGet();
                    AtomicInteger a1 = map.get(temp);
                    AtomicInteger a2 = map1.get(temp);

                    if (a1.intValue() >= a2.intValue()) {
                        a1.decrementAndGet();
                    }
                }
                left++;
            }
        }
        return len != Integer.MAX_VALUE ? s.substring(start, start + len) : "";
    }
}
