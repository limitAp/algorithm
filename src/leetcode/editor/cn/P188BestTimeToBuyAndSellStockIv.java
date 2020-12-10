package leetcode.editor.cn;
//给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1： 
//
// 
//输入：k = 2, prices = [2,4,1]
//输出：2
//解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。 
//
// 示例 2： 
//
// 
//输入：k = 2, prices = [3,2,6,5,0,3]
//输出：7
//解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
//     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 
//。 
//
// 
//
// 提示： 
//
// 
// 0 <= k <= 109 
// 0 <= prices.length <= 1000 
// 0 <= prices[i] <= 1000 
// 
// Related Topics 动态规划 
// 👍 332 👎 0

public class P188BestTimeToBuyAndSellStockIv {
    public static void main(String[] args) {
        Solution solution = new P188BestTimeToBuyAndSellStockIv().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int k, int[] prices) {
            int length = prices.length;
            if (k > length / 2) {
                return maxProfit_two(prices);
            }
            int[][][] dp = new int[length][k+1][2];
            for (int i = 0; i < length; i++) {
                for (int m = k; m >= 1; m--) {
                    if (i - 1 == -1) {
                        dp[i][m][0] = 0;
                        dp[i][m][1] = Integer.MIN_VALUE;
                    }
                    dp[i][m][0] = Math.max(dp[i - 1][m][0], dp[i - 1][m][1] + prices[i]);
                    dp[i][m][1] = Math.max(dp[i - 1][m][1], dp[i - 1][m - 1][0] - prices[i]);

                }
            }
            return dp[length - 1][k][0];
        }
        public int maxProfit_two(int[] prices) {
            int length = prices.length;
            if (length == 0) {
                return 0;
            }
//            int[][][] dp = new int[length][3][2];
            int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE;
            int dp_i20 = 0, dp_i21 = Integer.MIN_VALUE;
            for (int i = 0; i < length; i++) {
//                    dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
//                    dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
                dp_i20 = Math.max(dp_i20, dp_i21 + prices[i]);
                dp_i21 = Math.max(dp_i21, dp_i10 - prices[i]);

                dp_i10 = Math.max(dp_i10, dp_i11 + prices[i]);
                dp_i11 = Math.max(dp_i11, -prices[i]);

            }
            return dp_i20;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}