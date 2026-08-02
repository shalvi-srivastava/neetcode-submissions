class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int p : piles) {
            max = Math.max(max, p);
        }
        int i = 1, j = max, ans = 0;
        while (i <= j) {
            int mid = (i + j) / 2;
            int hrs = calHrs(piles, mid, h);
            if (hrs <= h) {
                ans = mid;
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return ans;
    }
    private int calHrs(int[] piles, int mid, int h) {
        int hrs = 0;
        for (int p : piles) {
            hrs += (p + mid - 1) / mid;
        }
        return hrs;
    }
}
