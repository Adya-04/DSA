class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];

            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;

                if (checkBalanced(freq)) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }

    public boolean checkBalanced(int[] freq){
        int common = 0;

        for(int f : freq){
            if(f==0) continue;

            if(common == 0){
                common = f;
            }
            else if(f!=common){
                return false;
            }
        }
        return true;
    }
}