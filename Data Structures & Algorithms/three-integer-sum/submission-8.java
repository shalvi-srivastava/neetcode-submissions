class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length - 1;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = n;
            while (j < k) {
                int sum = nums[i] + nums[k] + nums[j];
            if (sum == 0) {
                ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                j++;
                k--;

                while (j < k && nums[j] == nums[j - 1]) j++;
                while (j < k && nums[k] == nums[k + 1]) k--;
            } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return ans;
    }
}
