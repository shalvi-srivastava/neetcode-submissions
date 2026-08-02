class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0, sum = 0, ans = Integer.MAX_VALUE;
        while (j < nums.length) {
            sum += nums[j];
            while (sum >= target) {
                ans = Math.min(ans, j - i + 1);
                sum -= nums[i];
                i++;
            }
            j++;
        }
        if (ans == Integer.MAX_VALUE) {
            return 0;
        }
        return ans;
    }
}