class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0, streak = 1;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int curr = num;
                while (set.contains(curr + 1)) {
                    curr++;
                    streak++;
                }
                
                longest=Math.max(streak, longest);
                streak=1;
            }
        }
        return longest;

    }
}
