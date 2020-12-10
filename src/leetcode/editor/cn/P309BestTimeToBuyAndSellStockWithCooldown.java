package leetcode.editor.cn;
//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 示例: 
//
// 输入: [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
// Related Topics 动态规划 
// 👍 616 👎 0

public class P309BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        Solution solution = new P309BestTimeToBuyAndSellStockWithCooldown().new Solution();
        // TO TEST
        System.out.println(solution.maxProfit(new int[]{1, 2, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length == 0) return 0;
            int length = prices.length;
//            int[][] dp = new int[length][2];
            int dp_i0 = 0, dp_i1 = Integer.MIN_VALUE;
            int dp_pre = 0;  //dp[i-2][0];
            for (int i = 0; i < prices.length; i++) {
//                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
//                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
                int temp = dp_i0;
                dp_i0 = Math.max(dp_i0, dp_i1 + prices[i]);
                dp_i1 = Math.max(dp_i1, dp_pre - prices[i]);
                dp_pre = temp;
            }
//            return dp[length - 1][0];
            return dp_i0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}