class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int i = 1, j = 0;
        for (int pile : piles) {
            j = Math.max(pile, j);
        }
        int ans = j;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            long hrs = calculateHrs(piles, mid);
            if (hrs <= h) {
                ans = mid;
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return ans;
    }
    private long calculateHrs(int[] piles, int k) {
        int hrs = 0;
        for (int pile : piles) {
            hrs += (pile + k - 1) / k;
        }
        return hrs;
    }
}
