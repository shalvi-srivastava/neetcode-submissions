class Solution {
    public boolean isAnagram(String s, String t) {
        int freqs[] = new int[26];
        int freqt[] = new int[26];
        int i = 0;
        while (i < s.length()) {
            char curr = s.charAt(i);
            freqs[curr - 'a']++;
            i++;
        }
        i = 0;
        while (i < t.length()) {
            char curr = t.charAt(i);
            freqt[curr - 'a']++;
            i++;
        }
        for (int j = 0; j < 26; j++) {
            if (freqs[j] != freqt[j]) {
                return false;
            }
        }
        return true;
    }
}
