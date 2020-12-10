package leetcode.editor.cn;
//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例： 
//
// 输入：4
//输出：[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// Related Topics 回溯算法 
// 👍 687 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P51NQueens {
    public static void main(String[] args) {
        Solution solution = new P51NQueens().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<String>> solveNQueens(int n) {
            char[][] nums = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    nums[i][j] = '.';
                }
            }
            List<List<String>> result = new LinkedList<>();
            if (n <= 0) {
                return result;
            }
            solveQueens(nums, result, 0);
            return result;
        }

        public void solveQueens(char[][] nums, List<List<String>> list, int row) {
            if (row == nums.length) {
                list.add(construct(nums));
                return;
            }
            for (int col = 0; col < nums.length; col++) {
                if (isValid(nums, row, col)) {
                    nums[row][col] = 'Q';
                    solveQueens(nums, list, row + 1);
                    nums[row][col] = '.';
                }
            }
        }

        public boolean isValid(char[][] nums, int row, int col) {
            // 判断当前行没有Q
            for (int i = 0; i < row; i++) {
                if (nums[i][col] == 'Q') {
                    return false;
                }
            }

            //右上角没Q

            for (int i = row - 1, j = col + 1; i >= 0 && j < nums.length; i--, j++) {
                if (nums[i][j] == 'Q') {
                    return false;
                }
            }
            //左上角没Q

            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (nums[i][j] == 'Q') {
                    return false;
                }
            }
            return true;
        }

        public List<String> construct(char[][] nums) {
            List<String> path = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                path.add(new String(nums[i]));
            }
            return path;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}