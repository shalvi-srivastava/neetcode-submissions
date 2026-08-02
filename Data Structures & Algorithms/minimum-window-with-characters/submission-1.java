class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] freq = new int[52];

        for (char ch : t.toCharArray()) {
            freq[getIndex(ch)]++;
        }

        int count = t.length();
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            int rightIndex = getIndex(rightChar);

            if (freq[rightIndex] > 0) {
                count--;
            }

            freq[rightIndex]--;

            while (count == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                int leftIndex = getIndex(leftChar);

                freq[leftIndex]++;

                if (freq[leftIndex] > 0) {
                    count++;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    private int getIndex(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            return ch - 'A';
        }

        return ch - 'a' + 26;
    }
}