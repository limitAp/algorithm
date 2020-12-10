package leetcode.editor.cn.arrays;

/**
 * 创建日期 2020/07/30
 *
 * @author pengzhuowei@fybdp.com
 * @since 1.0.0
 */
public class Code299 {
    public static void main(String[] args) {

        String hint = getHint("1807", "7810");
        // 1  1
        System.out.println(hint);
    }

    public static String getHint(String secret, String guess) {
        int len = secret.length();
        int x = 0;
        int y = 0;
        int[] cache = new int[10];
        for (int i = 0; i < len; i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                x++;
            } else {
                if (cache[s - '0']++ < 0) y++;
                if (cache[g - '0']-- > 0) y++;
            }
        }
        return x + "A" + y + "B";
    }
}
