class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int i = 0, j = 0;
        for (int w : weights) {
            i = Math.max(i, w);
            j += w;
        }
        int ans = j;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (canShip(weights, days, mid)) {
                ans = mid;
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return ans;
    }
    private boolean canShip(int[] weights, int days, int capacity) {
        int currDays = 1;
        int currLoad = 0;

        for (int w : weights) {
            if (currLoad + w > capacity) {
                currDays++;
                currLoad = 0;
            }
            currLoad += w;
        }
        return currDays <= days;
    }
}