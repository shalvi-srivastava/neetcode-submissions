class Solution {
    public int majorityElement(int[] nums) {
        int c = 0, r = 0;
        for (int num : nums) {
            if (c == 0) {
                r = num;
            }
            if (num == r) {
                c++;
            } else {
                c--;
            }
        }
        return r;
    }
}