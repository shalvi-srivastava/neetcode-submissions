class Solution {
    public int findMin(int[] nums) {
        int i = 0, j = nums.length - 1, min = nums[0];
        while (i <= j) {
            if (nums[i] < nums[j]) {
                min = Math.min(min, nums[i]);
            }
            int mid = i + (j - i) / 2;
            min = Math.min(min, nums[mid]);
            if (nums[mid] >= nums[i]) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return min;
    }
}
