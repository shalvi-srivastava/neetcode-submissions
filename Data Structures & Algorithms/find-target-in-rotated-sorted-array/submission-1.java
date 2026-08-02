class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        // Step 1: find pivot
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        int pivot = l;

        // Step 2: decide search space
        l = 0;
        r = nums.length - 1;

        if (target >= nums[pivot] && target <= nums[r]) {
            l = pivot;
        } else {
            r = pivot - 1;
        }

        // Step 3: normal binary search
        while (l <= r) {
            int mid = (l + r) / 2;

            if (nums[mid] == target) return mid;

            if (nums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }

        return -1;
    }
}