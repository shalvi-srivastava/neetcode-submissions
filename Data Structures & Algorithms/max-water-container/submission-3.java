class Solution {
    public int maxArea(int[] heights) {
        int i = 0, j = heights.length - 1, ans = 0;
        while (i < j) {
            int area = (j - i) * Math.min(heights[i], heights[j]);
            ans = Math.max(ans, area);
            if (heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            }
        }
        return ans;
    }
}
