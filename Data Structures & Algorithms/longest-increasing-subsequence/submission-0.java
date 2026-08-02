class Solution {
public int lengthOfLIS(int[] nums) {

        // int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int nums2[] = new int[set.size()];
        int i = 0;
        for (int num : set) {
            nums2[i] = num;
            i++;

        }
        Arrays.sort(nums2);
        return lcsTab(nums, nums2);

    }

    public int lcsTab(int[] nums, int[] nums2) {
        int n = nums.length, m = nums2.length;
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (nums[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];

    }
}
