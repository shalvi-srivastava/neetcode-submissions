class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();

        if (n > m) return "";

        int[] need = new int[128];
        int[] window = new int[128];

        int required = 0;

        for (int i = 0; i < n; i++) {
            char ch = t.charAt(i);

            if (need[ch] == 0) {
                required++;
            }

            need[ch]++;
        }

        int formed = 0;
        int left = 0;

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < m; right++) {
            char ch = s.charAt(right);
            window[ch]++;

            if (need[ch] > 0 && window[ch] == need[ch]) {
                formed++;
            }

            while (formed == required) {
                int currLen = right - left + 1;

                if (currLen < minLen) {
                    minLen = currLen;
                    start = left;
                }

                char leftChar = s.charAt(left);
                window[leftChar]--;

                if (need[leftChar] > 0 && window[leftChar] < need[leftChar]) {
                    formed--;
                }

                left++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLen);
    }
}