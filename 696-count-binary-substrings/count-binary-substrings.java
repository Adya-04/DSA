class Solution {
    public int countBinarySubstrings(String s) {
        int prev = 0;
        int curr = 1;

        int i = 1;
        int result = 0;
        while(i<s.length()){
            if(s.charAt(i) == s.charAt(i-1)){
                curr++;
            }
            else{
                result += Math.min(prev,curr);
                prev = curr;
                curr = 1;
            }
            i++;
        }
        return result + Math.min(prev,curr);
    }
}