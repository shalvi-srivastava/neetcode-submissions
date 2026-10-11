class Solution {
    public int sumOfSquares(int[] nums) {
        ArrayList<Integer> special = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i <= nums.length; i++) {
            if (n % (i+1) == 0) {
                special.add(nums[i]);
            }
        }
        int sum = 0;
        for (int s : special) {
            sum += s * s;
        }
        return sum;
    }
}