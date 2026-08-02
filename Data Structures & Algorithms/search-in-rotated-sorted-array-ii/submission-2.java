class Solution {
    // 1. Check mid
    // 2. Check which side is sorted
    // 3. Check if target lies in sorted side
    // 4. If yes → go there
    // 5. If no → go other side
    public boolean search(int[] nums, int k) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (nums[m] == k) {
                return true;
            }
            if (nums[i] < nums[m]) {
                if (nums[i] <= k && k < nums[m]) {
                    j = m - 1;
                } else {
                    i = m + 1;
                }
            } else if (nums[i] > nums[m]) {
                if (nums[m] < k && k <= nums[j]) {
                    i = m + 1;
                } else {
                    j = m - 1;
                }
            } else {
                i++;
            }
        }
        return false;
    }
}
