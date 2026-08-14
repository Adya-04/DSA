class Solution {
    public int maximumLengthSubstring(String s) {

        int[] freq = new int[26];
        int start = 0;
        int maxLen = 0;

        for (int end = 0; end < s.length(); end++) {

            char ch = s.charAt(end);
            freq[ch - 'a']++;

            // agar kisi character ki frequency 3 ho jaye
            while (freq[ch - 'a'] > 2) {
                freq[s.charAt(start) - 'a']--;
                start++;
            }

            // current valid window ka length
            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }
}