class Solution {
    public void reverse(int[] a, int s, int e) {
        while (s < e) {
            int temp = a[s];
            a[s] = a[e];
            a[e] = temp;
            s++;
            e--;
        }
    }

    public int[] sortedSquares(int[] nums) {
        int i = 0;
        while (i < nums.length && nums[i] < 0) {
            i++;
        }
        if (i >= 1) {
            reverse(nums, 0, i - 1);
        }
        for (int k = 0; k < nums.length; k++) {
            nums[k] = nums[k] * nums[k];
        }
        int ans[] = new int[nums.length];
        int left = 0;
        int right = i;
        int idx = 0;

        // merge
        while (left < i && right < nums.length) {

            if (nums[left] <= nums[right]) {
                ans[idx++] = nums[left++];
            } else {
                ans[idx++] = nums[right++];
            }
        }

        while (left < i) {
            ans[idx++] = nums[left++];
        }

        while (right < nums.length) {
            ans[idx++] = nums[right++];
        }
        return ans;

    }
}