class Solution {
    public int maxProfit(int[] prices) {
        int i = 0, ans = 0;
        for (int j = 1; j < prices.length; j++) {
            if (prices[i] < prices[j]) {
                ans = Math.max(ans, prices[j] - prices[i]);
            } else {
                i = j;
            }
        }
        return ans;
    }
}
