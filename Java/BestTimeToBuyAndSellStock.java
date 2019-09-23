/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell 
 * one share of the stock), design an algorithm to find the maximum profit.
 * 
 * Note that you cannot sell a stock before you buy one.
 * 
 * Example 1:
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *            Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
*/

/**
 * 找出数组中后面元素与前面的最大差值
 */
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();
        int[] prices_1 = {7,1,5,3,6,4};
        int[] prices_2 = {7,6,4,3,1};
        System.out.println(solution.maxProfit_1(prices_1));
        System.out.println(solution.maxProfit_1(prices_2));

        System.out.println(solution.maxProfit_2(prices_1));
        System.out.println(solution.maxProfit_2(prices_2));
    }

    /**
     * 暴力解法
     * @param prices
     * @return
     */
    public int maxProfit_1(int[] prices) {
        int max = 0;
        for (int i=prices.length-1; i>=0; i--) {
            for (int j=i-1;j>=0;j--) {
                max = Math.max(max, prices[i]-prices[j]);
            }
        }
        return max;
    }

    /**
     * 动态规划：需要找出最小元素之后的最大差值
     * 前i天的最大收益 = max{前i-1天的最大收益，第i天的价格-前i-1天中的最小价格}
     */
    public int maxProfit_2(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i=0; i<prices.length; i++) {
            //如果当前元素比最小元素小，作为最小元素
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {//否则，查看是否是最大差值
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}