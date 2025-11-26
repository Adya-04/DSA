class Solution {
public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {

    int n = s.length();  
    if (n < minSize) return 0;  

    Map<String, Integer> countMap = new HashMap<>();  

    int[] freq = new int[26];   // counts of letters inside window  
    int unique = 0;             // number of distinct letters in window  
    int L = minSize;  

    // initialize the first window  
    for (int i = 0; i < L; i++) {  
        int idx = s.charAt(i) - 'a';  
        if (freq[idx] == 0) unique++;  
        freq[idx]++;  
    }  

    // check first window  
    if (unique <= maxLetters) {  
        String sub = s.substring(0, L);  
        countMap.put(sub, countMap.getOrDefault(sub, 0) + 1);  
    }  

    // slide the window  
    for (int start = 1; start <= n - L; start++) {  
        // remove left char  
        int leftIdx = s.charAt(start - 1) - 'a';  
        freq[leftIdx]--;  
        if (freq[leftIdx] == 0) unique--;  

        // add right char  
        int rightIdx = s.charAt(start + L - 1) - 'a';  
        if (freq[rightIdx] == 0) unique++;  
        freq[rightIdx]++;  

        // check if valid  
        if (unique <= maxLetters) {  
            String sub = s.substring(start, start + L);  
            countMap.put(sub, countMap.getOrDefault(sub, 0) + 1);  
        }  
    }  

    int ans = 0;  
    for (int value : countMap.values()) {  
        ans = Math.max(ans, value);  
    }  

    return ans;  
}  
}