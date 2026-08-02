class Solution {
    public int lengthOfLongestSubstring(String s) {
        int count = 0;
        HashSet<Character> set = new HashSet<>();
        int i = 0, j = 0;
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                count = Math.max(count, j - i + 1);
                j++;
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }

        return count;
    }
}
